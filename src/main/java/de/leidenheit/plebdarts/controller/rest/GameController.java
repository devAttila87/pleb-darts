package de.leidenheit.plebdarts.controller.rest;

import de.leidenheit.plebdarts.resource.api.error.ApiError;
import de.leidenheit.plebdarts.resource.api.game.CreateGameResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "api/games",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = @Content(schema = @Schema(implementation = ApiError.class))),
        @ApiResponse(
                description = "Unprocessable Entity",
                responseCode = "422",
                content = @Content(schema = @Schema(implementation = ApiError.class))),
        @ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = @Content(schema = @Schema(implementation = ApiError.class)))})
@SecurityRequirements(value = {
        @SecurityRequirement(name = PlebDartsOpenApiDefinition.AUTHENTICATION_SCHEME_BASIC_AUTH),
        @SecurityRequirement(name = PlebDartsOpenApiDefinition.AUTHENTICATION_SCHEME_BEARER)})
public class GameController {

    @PostMapping
    @Operation(
            tags = "Game",
            summary = "Creates new game instance.",
            description = "Creates a game instance based on the information provided by `CreateGameResource`.",
            requestBody = @RequestBody(
                    content = @Content(schema = @Schema(implementation = CreateGameResource.class)),
                    required = true),
            responses = {
                    @ApiResponse(
                            description = "Returns the uri to the created game.",
                            responseCode = "201",
                            headers = {
                                    @Header(name = "Location",
                                            description = "The location of the created game resource.",
                                            schema = @Schema(type = "string"))})})
    public ResponseEntity<Void> createGame(@NotNull @Valid CreateGameResource createGameResource) {
        // TODO replace dummy implementation
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(4711)
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(locationUri)
                .build();
    }
}
