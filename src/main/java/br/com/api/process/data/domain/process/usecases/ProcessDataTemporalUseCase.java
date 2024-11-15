package br.com.api.process.data.domain.process.usecases;

import br.com.api.process.data.domain.process.entity.DataTemporalEntity;
import br.com.api.process.data.domain.process.exceptions.ProcessDataTemporalException;

public interface ProcessDataTemporalUseCase {
    void execute(DataTemporalEntity dataTemporalEntity) throws ProcessDataTemporalException;
}
