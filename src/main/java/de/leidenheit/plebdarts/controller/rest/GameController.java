package de.leidenheit.plebdarts.controller.rest;

import de.leidenheit.plebdarts.mapper.GameMapper;
import de.leidenheit.plebdarts.resource.api.error.ApiError;
import de.leidenheit.plebdarts.resource.api.game.CreateGameResource;
import de.leidenheit.plebdarts.resource.api.game.GameReadResource;
import de.leidenheit.plebdarts.resource.api.game.GameUpdateResource;
import de.leidenheit.plebdarts.resource.api.game.JoinGameResource;
import de.leidenheit.plebdarts.resource.api.game.LeaveGameResource;
import de.leidenheit.plebdarts.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/games", produces = MediaType.APPLICATION_JSON_VALUE)
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

    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/{id}")
    @Operation(tags = "Game",
            summary = "Returns a game resource by its technical id.",
            operationId = "retrieveGameById",
            parameters = {
                    @Parameter(
                            name = "id",
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "long"),
                            description = "The technical id of the game.",
                            required = true)},
            responses = {
                    @ApiResponse(
                            description = "Returns the requested game resource.",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = GameReadResource.class))),
                    @ApiResponse(
                            description = "The requested game was not found.",
                            responseCode = "404",
                            content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ResponseEntity<GameReadResource> retrieveGameById(
            @PathVariable("id") Long gameId) {
        final var resultResource = GameMapper.MAPPER.mapGameToGameReadResource(
                gameService.retrieveGameById(gameId));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultResource);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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
        /* TODO replace dummy implementation
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(4711)
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(locationUri)
                .build();
         */
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping(path = "/{id}/joins", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags = "Game",
            summary = "Joins an existing game.",
            description = "Joins the passed game instance with the information provided by `JoinGameResource`.",
            operationId = "joinGame",
            parameters = {
                    @Parameter(
                            name = "id",
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string"),
                            description = "The technical id of the game.",
                            required = true)},
            requestBody = @RequestBody(
                    content = @Content(schema = @Schema(implementation = JoinGameResource.class)),
                    description = "Resource with join information.",
                    required = true),
            responses = {
                    @ApiResponse(
                            description = "Joined the game resource.",
                            responseCode = "303",
                            headers = {
                                    @Header(name = "Location",
                                            description = "The location of the joined game resource.",
                                            schema = @Schema(type = "string"))}),
                    @ApiResponse(
                            description = "The requested game was not found.",
                            responseCode = "404",
                            content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ResponseEntity<Void> joinGame(@PathVariable("id") String gameId,
                                         @NotNull @Valid JoinGameResource joinGameResource) {
        /* TODO replace dummy implementation
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(gameId)
                .toUri();
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(locationUri)
                .build();
        */
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping(path = "/{id}/leaves", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags = "Game",
            summary = "Leave an existing game.",
            description = "Leaves the passed game instance with the information provided by `LeaveGameResource`.",
            operationId = "leaveGame",
            parameters = {
                    @Parameter(
                            name = "id",
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string"),
                            description = "The technical id of the game.",
                            required = true)},
            requestBody = @RequestBody(
                    content = @Content(schema = @Schema(implementation = LeaveGameResource.class)),
                    description = "Resource with leave information.",
                    required = true),
            responses = {
                    @ApiResponse(
                            description = "Left the game resource.",
                            responseCode = "303",
                            headers = {
                                    @Header(name = "Location",
                                            description = "The location of the left game resource.",
                                            schema = @Schema(type = "string"))}),
                    @ApiResponse(
                            description = "The requested game was not found.",
                            responseCode = "404",
                            content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ResponseEntity<Void> leaveGame(@PathVariable("id") String gameId,
                                     @NotNull @Valid LeaveGameResource leaveGameResource) {
        /* TODO replace dummy implementation
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(gameId)
                .toUri();
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(locationUri)
                .build();
         */
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping(path = "{id}/turns", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags = "Game",
            summary = "Updates an existing game instance.",
            description = "Updates an existing game instance based on the information provided by `GameUpdateResource`.",
            operationId = "updateGame",
            requestBody = @RequestBody(
                    content = @Content(schema = @Schema(implementation = GameUpdateResource.class)),
                    required = true),
            responses = {
                    @ApiResponse(
                            description = "State of the game resource was updated.",
                            responseCode = "303",
                            headers = {
                                    @Header(name = "Location",
                                            description = "The location of the updated game resource.",
                                            schema = @Schema(type = "string"))}),
                    @ApiResponse(
                            description = "The requested game was not found.",
                            responseCode = "404",
                            content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ResponseEntity<Void> updateGame(@PathVariable("id") String gameId,
                                           @NotNull @Valid GameUpdateResource gameUpdateResource) {
        /* TODO replace dummy implementation
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(gameId)
                .toUri();
        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(locationUri)
                .build();
         */
        return ResponseEntity.internalServerError().build();
    }
}
