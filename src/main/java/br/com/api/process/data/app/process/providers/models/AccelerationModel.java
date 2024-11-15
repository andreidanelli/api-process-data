package br.com.api.process.data.app.process.providers.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccelerationModel {
    private Double value;
    private String unit;
}
