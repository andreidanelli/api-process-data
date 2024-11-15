package br.com.api.process.data.app.configurations;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Singleton;
import lombok.Getter;

@Singleton
@Getter
public class AppConfigurations {

    @ConfigProperty(name = "environment")
    String environment;
}