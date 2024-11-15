package br.com.api.process.data.app.mongo.providers;

import br.com.api.process.data.app.mongo.providers.converters.DataTemporalEntityToDocumentCollectionConvert;
import br.com.api.process.data.app.mongo.providers.repositories.IMongoRepository;
import br.com.api.process.data.domain.mongo.dataproviders.SaveDataTemporalMongoDataProvider;
import br.com.api.process.data.domain.process.entity.DataTemporalEntity;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
public class SaveDataTemporalMongoProvider implements SaveDataTemporalMongoDataProvider {

    private final IMongoRepository mongoRepository;

    private final DataTemporalEntityToDocumentCollectionConvert dataTemporalEntityToDocumentCollectionConvert;

    @Override
    public void execute(DataTemporalEntity dataTemporalEntity) {
        try {
            mongoRepository.execute(dataTemporalEntityToDocumentCollectionConvert.execute(dataTemporalEntity));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
