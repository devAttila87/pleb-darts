package de.leidenheit.plebdarts.service;

import de.leidenheit.plebdarts.repository.GameRepository;
import de.leidenheit.plebdarts.resource.api.error.exception.GameNotFoundException;
import de.leidenheit.plebdarts.resource.entity.game.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game retrieveGameById(long gameId) {
        return gameRepository
                .findById(gameId)
                .orElseThrow(() -> new GameNotFoundException(String.valueOf(gameId)));



    }
}
