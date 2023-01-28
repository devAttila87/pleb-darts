package de.leidenheit.plebdarts.resource.api.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Defines a validation error for a parameter or field.")
@Data
public class ApiInvalidParam {

    @Schema(description = "The name of the validation annotation given in uppercase, underscore notation.",
            example = "FIELD_CORRELATION_ERROR")
    private String errorCode;
    @Schema(description = "The name or path of the invalid field or parameter.", example = "Lorem Ipsum")
    private String field;
    @Schema(description = "Gives a hint why the value is not valid. This is the error message of the validation. " +
            "The reason might be in different language due to internationalization.", example = "Lorem")
    private String reason;
}
