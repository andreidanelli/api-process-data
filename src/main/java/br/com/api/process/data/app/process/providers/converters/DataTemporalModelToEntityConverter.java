package br.com.api.process.data.app.process.providers.converters;

import br.com.api.process.data.app.process.providers.models.DataTemporalModel;
import br.com.api.process.data.app.process.providers.models.TemperatureModel;
import br.com.api.process.data.app.process.providers.models.VibrationModel;
import br.com.api.process.data.domain.process.entity.AccelerationEntity;
import br.com.api.process.data.domain.process.entity.DataTemporalEntity;
import br.com.api.process.data.domain.process.entity.TemperatureEntity;
import br.com.api.process.data.domain.process.entity.VelocityEntity;
import br.com.api.process.data.domain.process.entity.VibrationEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataTemporalModelToEntityConverter {
    
    public DataTemporalEntity execute(DataTemporalModel model) {
        if (model == null) {
            return new DataTemporalEntity();
        }

        DataTemporalEntity dataTemporalEntity = new DataTemporalEntity();
        dataTemporalEntity.setSensor_id(model.getSensor_id());
        dataTemporalEntity.setTimestamp(model.getTimestamp());

        if (model.getVibration() != null) {
            VibrationEntity vibrationEntity = convertVibration(model.getVibration());
            dataTemporalEntity.setVibration(vibrationEntity);
        }

        if (model.getTemperature() != null) {
            TemperatureEntity temperatureEntity = convertTemperature(model.getTemperature());
            dataTemporalEntity.setTemperature(temperatureEntity);
        }

        return dataTemporalEntity;
    }

    private VibrationEntity convertVibration(VibrationModel vibrationModel) {
        VibrationEntity vibrationEntity = new VibrationEntity();

        if (vibrationModel.getVelocity() != null) {
            VelocityEntity velocityEntity = new VelocityEntity();
            velocityEntity.setValue(vibrationModel.getVelocity().getValue());
            velocityEntity.setUnit(vibrationModel.getVelocity().getUnit());
            vibrationEntity.setVelocity(velocityEntity);
        }

        if (vibrationModel.getAcceleration() != null) {
            AccelerationEntity accelerationEntity = new AccelerationEntity();
            accelerationEntity.setValue(vibrationModel.getAcceleration().getValue());
            accelerationEntity.setUnit(vibrationModel.getAcceleration().getUnit());
            vibrationEntity.setAcceleration(accelerationEntity);
        }

        return vibrationEntity;
    }

    private TemperatureEntity convertTemperature(TemperatureModel temperatureModel) {
        TemperatureEntity temperatureEntity = new TemperatureEntity();
        temperatureEntity.setValue(temperatureModel.getValue());
        temperatureEntity.setUnit(temperatureModel.getUnit());
        return temperatureEntity;
    }
}