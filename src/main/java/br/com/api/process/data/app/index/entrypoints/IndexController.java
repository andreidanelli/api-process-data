package br.com.api.process.data.app.index.entrypoints;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import br.com.api.process.data.app.configurations.AppConfigurations;
import br.com.api.process.data.app.index.entrypoints.resource.IndexResource;
import io.quarkus.info.BuildInfo;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@RequestScoped
@Path("/")
@AllArgsConstructor
public class IndexController implements IndexResource {

    private AppConfigurations appConfigurations;

    private BuildInfo buildInfo;

    private Template index;

    @GET
    @Override
    public TemplateInstance execute() {
        OffsetDateTime dateTimeBuild = buildInfo.time();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return index.data("version", buildInfo.version())
        .data("update", dateTimeBuild.format(formatter))
        .data("environment", appConfigurations.getEnvironment());
    }
}
