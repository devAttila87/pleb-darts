package de.leidenheit.plebdarts.controller.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import static de.leidenheit.plebdarts.controller.rest.PlebDartsOpenApiDefinition.AUTHENTICATION_SCHEME_BASIC_AUTH;
import static de.leidenheit.plebdarts.controller.rest.PlebDartsOpenApiDefinition.AUTHENTICATION_SCHEME_BEARER;

@OpenAPIDefinition(
        info = @Info(
                title = "Pleb Darts API",
                description = "501 darts game counter for two participants.",
                version = "0.0.1a",
                termsOfService = "https://leidenheit.hns.to/plebdarts/tos",
                contact = @Contact(
                        name = "leidenheit",
                        url = "https://leidenheit.hns.to"),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/git/git-scm.com/blob/main/MIT-LICENSE.txt")))
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "BasicAuth",
        scheme = AUTHENTICATION_SCHEME_BASIC_AUTH,
        description = "Basic Authentication")
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "JsonWebToken",
        description = "Passes the Bearer Token (JWT) to the service class.",
        scheme = AUTHENTICATION_SCHEME_BEARER,
        bearerFormat = "JWT")
public class PlebDartsOpenApiDefinitionImpl implements PlebDartsOpenApiDefinition {
}
