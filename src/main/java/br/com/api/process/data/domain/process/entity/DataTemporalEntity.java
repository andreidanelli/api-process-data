package br.com.api.process.data.domain.process.entity;

import java.time.OffsetDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataTemporalEntity {
    private String sensor_id;
    private OffsetDateTime timestamp;
    private VibrationEntity vibration;
    private TemperatureEntity temperature;
}