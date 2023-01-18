package de.leidenheit.plebdarts.service;

import de.leidenheit.plebdarts.resource.websocket.CreateGameResponse;
import de.leidenheit.plebdarts.resource.websocket.game.GameData;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public CreateGameResponse createGame(long clientId) {
        final var gameData = GameData.builder().build();
        return CreateGameResponse.builder()
                .setClientId(clientId)
                .setContent(gameData)
                .build();
    }
}
