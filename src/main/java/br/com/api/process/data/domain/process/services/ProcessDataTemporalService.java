package br.com.api.process.data.domain.process.services;

import br.com.api.process.data.domain.mongo.dataproviders.SaveDataTemporalMongoDataProvider;
import br.com.api.process.data.domain.process.entity.DataTemporalEntity;
import br.com.api.process.data.domain.process.exceptions.ProcessDataTemporalException;
import br.com.api.process.data.domain.process.usecases.ProcessDataTemporalUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
public class ProcessDataTemporalService implements ProcessDataTemporalUseCase {

    private final SaveDataTemporalMongoDataProvider saveDataTemporalMongoDataProvider;

    @Override
    public void execute(DataTemporalEntity dataTemporalEntity) throws ProcessDataTemporalException {
        try {
            saveDataTemporalMongoDataProvider.execute(dataTemporalEntity);
        } catch (Exception e) {
            throw new ProcessDataTemporalException(e.getMessage());
        }
    }
}
