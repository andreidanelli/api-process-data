package br.com.api.process.data.domain.mongo.dataproviders;

import br.com.api.process.data.domain.process.entity.DataTemporalEntity;

public interface SaveDataTemporalMongoDataProvider {
    void execute(DataTemporalEntity dataTemporalEntity);
}
