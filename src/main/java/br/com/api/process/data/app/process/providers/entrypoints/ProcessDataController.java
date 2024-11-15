package br.com.api.process.data.app.process.providers.entrypoints;

import br.com.api.process.data.app.process.providers.converters.DataTemporalModelToEntityConverter;
import br.com.api.process.data.app.process.providers.entrypoints.resource.ProcessDataResource;
import br.com.api.process.data.app.process.providers.models.DataTemporalModel;
import br.com.api.process.data.domain.process.usecases.ProcessDataTemporalUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/api")
@RequestScoped
@AllArgsConstructor
public class ProcessDataController implements ProcessDataResource {

    private final DataTemporalModelToEntityConverter dataTemporalModelToEntityConverter;

    private final ProcessDataTemporalUseCase processDataTemporalUseCase;

    @POST
    @Path("/process")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response execute(DataTemporalModel dataProcessModel) {
        try {
            processDataTemporalUseCase.execute(dataTemporalModelToEntityConverter.execute(dataProcessModel));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
