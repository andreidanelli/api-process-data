package br.com.api.process.data.app.mongo.providers.repositories;

import com.mongodb.client.MongoClient;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@ApplicationScoped
public class MongoRepository implements IMongoRepository {
    
    private MongoClient mongoClient;

    @Override
    public void execute() {
        try {
            MongoClient = new MongoClient("localhost", 27017);

        } catch (Exception e) {
            
        }
    }
}
