package de.leidenheit.plebdarts.resource.api.game.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "The darts game type.")
@Getter
public enum GameTypeResource {
    @Schema(description = "Traditional 501 Double Out")
    GT_501("501");

    private final String alias;

    GameTypeResource(String alias) {
        this.alias = alias;
    }
}
