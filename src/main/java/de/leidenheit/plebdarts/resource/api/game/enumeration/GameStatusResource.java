package de.leidenheit.plebdarts.resource.api.game.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The state the game is in.")
public enum GameStatusResource {
    NEW,
    PENDING,
    COMPLETED
}
