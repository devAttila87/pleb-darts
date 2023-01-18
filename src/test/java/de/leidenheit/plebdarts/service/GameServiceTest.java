package de.leidenheit.plebdarts.service;

import de.leidenheit.plebdarts.resource.websocket.PlebMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService underTest;

    @Test
    @DisplayName("should create new game for session 4711")
    void shouldCreateGameForSession4711() {
        // given
        // when
        final var response = underTest.createGame(4711);
        // then
        assertNotNull(response);
        assertEquals(4711, response.clientId());
        assertEquals(PlebMethod.CREATE_GAME, response.plebMethod());
        final var gameData = response.content();
        assertNotNull(gameData);
    }

}