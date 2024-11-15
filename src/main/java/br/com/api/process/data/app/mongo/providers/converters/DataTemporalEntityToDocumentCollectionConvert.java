package br.com.api.process.data.app.mongo.providers.converters;

import org.bson.Document;

import br.com.api.process.data.domain.process.entity.DataTemporalEntity;
import br.com.api.process.data.domain.process.entity.TemperatureEntity;
import br.com.api.process.data.domain.process.entity.VibrationEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataTemporalEntityToDocumentCollectionConvert {
    
    public Document execute(DataTemporalEntity dataTemporalEntity) {
        try {
            Document document = new Document();
            document.append("sensor_id", dataTemporalEntity.getSensor_id())
                    .append("timestamp", dataTemporalEntity.getTimestamp().toString());

            if (dataTemporalEntity.getVibration() != null) {
                document.append("vibration", convertVibration(dataTemporalEntity.getVibration()));
            }

            if (dataTemporalEntity.getTemperature() != null) {
                document.append("temperature", convertTemperature(dataTemporalEntity.getTemperature()));
            }

            return document;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error converting DataTemporalEntity to Document", e);
        }
    }

    private Document convertVibration(VibrationEntity vibrationEntity) {
        Document vibrationDoc = new Document();
        if (vibrationEntity.getVelocity() != null) {
            vibrationDoc.append("velocity", new Document("value", vibrationEntity.getVelocity().getValue())
                .append("unit", vibrationEntity.getVelocity().getUnit()));
        }
        if (vibrationEntity.getAcceleration() != null) {
            vibrationDoc.append("acceleration", new Document("value", vibrationEntity.getAcceleration().getValue())
                .append("unit", vibrationEntity.getAcceleration().getUnit()));
        }
        return vibrationDoc;
    }

    private Document convertTemperature(TemperatureEntity temperatureEntity) {
        return new Document("value", temperatureEntity.getValue())
                .append("unit", temperatureEntity.getUnit());
    }
}
