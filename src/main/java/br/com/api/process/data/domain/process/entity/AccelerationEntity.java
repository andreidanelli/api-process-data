package br.com.api.process.data.domain.process.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccelerationEntity {
    private Double value;
    private String unit;
}
