package br.com.api.process.data.app.process.providers.models;

import java.time.OffsetDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataTemporalModel {
    private String sensor_id;
    private OffsetDateTime timestamp;
    private VibrationModel vibration;
    private TemperatureModel temperature;
}