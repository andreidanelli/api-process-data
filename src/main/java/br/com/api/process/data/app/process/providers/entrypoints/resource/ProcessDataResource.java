package br.com.api.process.data.app.process.providers.entrypoints.resource;

import br.com.api.process.data.app.process.providers.models.DataTemporalModel;
import jakarta.ws.rs.core.Response;

public interface ProcessDataResource {
    Response execute(DataTemporalModel dataProcessModel);
}
