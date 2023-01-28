package de.leidenheit.plebdarts.resource.api.game;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Contains information for the game to be created.")
@Data
@Builder(setterPrefix = "set")
public class CreateGameResource {
}
