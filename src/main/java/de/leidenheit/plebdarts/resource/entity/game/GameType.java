package de.leidenheit.plebdarts.resource.entity.game;

import lombok.Getter;

@Getter
public enum GameType {
    GT_501("501");

    private final String alias;

    GameType(String alias) {
        this.alias = alias;
    }
}
