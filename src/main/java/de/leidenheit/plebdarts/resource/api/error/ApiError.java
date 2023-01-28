package de.leidenheit.plebdarts.resource.api.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Schema(description = "Describes an api error object to transfer error information between server and client.")
@Data
@Builder(setterPrefix = "set")
public class ApiError {

    @Schema(description = "The human readable description of the error.", example = "Request parameters are not valid")
    private String title;

    @Schema(description = "Contains a list of invalid parameters in case of validation errors. " +
            "Parameters in this case can be for example fields in a Json of the request body or query params.")
    private List<ApiInvalidParam> invalidParameters;
}

