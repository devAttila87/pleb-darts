package de.leidenheit.plebdarts.resource.api.game;

import de.leidenheit.plebdarts.resource.api.game.enumeration.GameStatusResource;
import de.leidenheit.plebdarts.resource.api.game.enumeration.GameTypeResource;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Schema(description = "Contains information about a game.")
@Data
@Builder(setterPrefix = "set")
public class GameReadResource {

    @Schema(description = "The technical identifier of a game.", example = "4711")
    private long id;

    @Schema(description = "Amount of turns made in the game.", example = "3")
    private int turns;

    @Schema(description = "Amount of darts thrown in the game.", example = "9")
    private int dartCount;

    @Schema(description = "The player that won the game.", implementation = PlayerReadResource.class)
    private PlayerReadResource winner;

    @ArraySchema(schema = @Schema(description = "List players assigned to a game.",
            implementation = PlayerReadResource.class))
    private List<PlayerReadResource> players;

    private GameStatusResource gameStatus;

    private GameTypeResource gameType;
}
