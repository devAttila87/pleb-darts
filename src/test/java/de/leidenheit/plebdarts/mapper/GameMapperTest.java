package de.leidenheit.plebdarts.mapper;

import de.leidenheit.plebdarts.resource.api.game.GameReadResource;
import de.leidenheit.plebdarts.resource.entity.game.Game;
import de.leidenheit.plebdarts.resource.entity.game.GameStatus;
import de.leidenheit.plebdarts.resource.entity.game.GameType;
import de.leidenheit.plebdarts.resource.entity.player.PersonalInfo;
import de.leidenheit.plebdarts.resource.entity.player.PersonalStatistics;
import de.leidenheit.plebdarts.resource.entity.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameMapperTest {

    private final GameMapper underTest = GameMapper.MAPPER;

    @Test
    void shouldMapGameToGameReadResource() {
        // given
        final Player player1 = Player.builder()
                .setId(1L)
                .setPersonalStatistics(
                        PersonalStatistics.builder()
                                .setGamesPlayed(100)
                                .setGamesWon(1)
                                .setAvgPerDart(10.5)
                                .setAvgPerLeg(32.75)
                                .setThrownDarts(4200)
                                .setCountOf180s(1)
                                .build())
                .setPersonalInfo(
                        PersonalInfo.builder()
                                .setNickname("Hugo")
                                .setEmail("h@u.go")
                                .setFirstName("Holger")
                                .setLastName("Groß")
                                .build())
                .build();
        final Player player2 = Player.builder()
                .setId(2L)
                .setPersonalStatistics(
                        PersonalStatistics.builder()
                                .setGamesPlayed(100)
                                .setGamesWon(1)
                                .setAvgPerDart(10.5)
                                .setAvgPerLeg(32.75)
                                .setThrownDarts(4200)
                                .setCountOf180s(1)
                                .build())
                .setPersonalInfo(
                        PersonalInfo.builder()
                                .setNickname("oguh")
                                .setEmail("go@u.h")
                                .setFirstName("Walter")
                                .setLastName("Klein")
                                .build())
                .build();
        Game game = Game.builder()
                .setId(42L)
                .setGameType(GameType.GT_501)
                .setGameStatus(GameStatus.COMPLETED)
                .setWinner(player1)
                .setPlayers(List.of(player1, player2))
                .setTurns(30)
                .build();

        // when
        final GameReadResource actual = underTest.mapGameToGameReadResource(game);

        // then
        assertNotNull(actual);
        assertEquals(42L, actual.getId());
    }
}
