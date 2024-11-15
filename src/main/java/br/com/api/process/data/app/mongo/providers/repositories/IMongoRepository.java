package br.com.api.process.data.app.mongo.providers.repositories;

import org.bson.Document;

public interface IMongoRepository {
    void execute(Document document);
}
