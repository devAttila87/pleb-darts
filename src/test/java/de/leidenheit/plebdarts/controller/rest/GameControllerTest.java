package de.leidenheit.plebdarts.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.leidenheit.plebdarts.resource.api.error.exception.GameNotFoundException;
import de.leidenheit.plebdarts.resource.api.error.handler.ApiExceptionHandler;
import de.leidenheit.plebdarts.resource.api.game.CreateGameResource;
import de.leidenheit.plebdarts.resource.api.game.GameUpdateResource;
import de.leidenheit.plebdarts.resource.api.game.JoinGameResource;
import de.leidenheit.plebdarts.resource.api.game.LeaveGameResource;
import de.leidenheit.plebdarts.resource.entity.game.Game;
import de.leidenheit.plebdarts.resource.entity.game.GameStatus;
import de.leidenheit.plebdarts.resource.entity.game.GameType;
import de.leidenheit.plebdarts.resource.entity.player.PersonalInfo;
import de.leidenheit.plebdarts.resource.entity.player.PersonalStatistics;
import de.leidenheit.plebdarts.resource.entity.player.Player;
import de.leidenheit.plebdarts.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    @Mock
    private GameService mockGameService;

    @InjectMocks
    private GameController underTest;


    private MockMvc mockMvc;

    @BeforeEach
    public void prepareTest() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(underTest)
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    // @Test
    @DisplayName("Dummy shouldReturn201CreatedForOpCreateGame")
    void shouldReturn201CreatedForOpCreateGame() {
        // given
        /* TODO
        when(mockGameService.createGame(GameTypeResource.GT_501))
                .thenReturn(CreateGameResource.builder()
                        .setGameType(GameTypeResource.GT_501)
                        .build());
         */
        // when
        final var body = asJsonString(CreateGameResource.builder().build());
        final var request = MockMvcRequestBuilders
                .post("/api/games")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        final var response = assertDoesNotThrow(() -> mockMvc.perform(request));
        // then
        assertDoesNotThrow(() -> {
            response.andExpect(status().isCreated())
                    .andExpect(header().exists(HttpHeaders.LOCATION))
                    .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/games/4711")));
        });
    }

    // @Test
    @DisplayName("Dummy shouldReturn303JoinedForOpJoinGame")
    void shouldReturn303JoinedForOpJoinGame() {
        // given
        // when
        final var body = asJsonString(JoinGameResource.builder().build());
        final var request = MockMvcRequestBuilders
                .post("/api/games/4711/joins")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        final var response = assertDoesNotThrow(() -> mockMvc.perform(request));
        // then
        assertDoesNotThrow(() -> {
            response.andExpect(status().isSeeOther())
                    .andExpect(header().exists(HttpHeaders.LOCATION))
                    .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/games/4711")));
        });
    }

    // @Test
    @DisplayName("Dummy shouldReturn303LeftForOpLeaveGame")
    void shouldReturn303LeftForOpLeaveGame() {
        // given
        // when
        final var body = asJsonString(LeaveGameResource.builder().build());
        final var request = MockMvcRequestBuilders
                .post("/api/games/4711/leaves")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        final var response = assertDoesNotThrow(() -> mockMvc.perform(request));
        // then
        assertDoesNotThrow(() -> {
            response.andExpect(status().isSeeOther())
                    .andExpect(header().exists(HttpHeaders.LOCATION))
                    .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/games/4711")));
        });
    }

    // @Test
    @DisplayName("Dummy shouldReturn303UpdatedForOpUpdateGame")
    void shouldReturn303UpdatedForOpUpdateGame() {
        // given
        // when
        final var body = asJsonString(GameUpdateResource.builder().build());
        final var request = MockMvcRequestBuilders
                .post("/api/games/4711/turns")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        final var response = assertDoesNotThrow(() -> mockMvc.perform(request));
        // then
        assertDoesNotThrow(() -> {
            response.andExpect(status().isSeeOther())
                    .andExpect(header().exists(HttpHeaders.LOCATION))
                    .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/games/4711")));
        });
    }

    @Test
    @DisplayName("should return 200 ok for retrieve game with id 4711")
    void shouldReturn200OkForRetrieveGameById() {
        // given
        final var expectedGameAsJson = "{}";

        final var personalInfo = PersonalInfo.builder()
                .setFirstName("A")
                .setLastName("B")
                .setNickname("l")
                .setDateOfBirth(LocalDate.of(2001, 1, 1))
                .setEmail("a@b.c")
                .build();
        final var personalStatistics = PersonalStatistics.builder()
                .setCountOf180s(1)
                .setGamesPlayed(21)
                .setGamesWon(1)
                .setAvgPerDart(10)
                .setAvgPerLeg(32.5)
                .build();
        final var stubbedPlayerOne = Player.builder()
                .setId(1)
                .setPersonalInfo(personalInfo)
                .setPersonalStatistics(personalStatistics)
                .build();
        final var stubbedPlayerTwo = Player.builder()
                .setId(2)
                .setPersonalInfo(personalInfo)
                .setPersonalStatistics(personalStatistics)
                .build();
        final var stubbedGame = Game.builder()
                .setId(4711L)
                .setGameStatus(GameStatus.NEW)
                .setGameType(GameType.GT_501)
                .setDartCount(42)
                .setTurns(14)
                .setPlayers(List.of(stubbedPlayerOne, stubbedPlayerTwo))
                .setWinner(stubbedPlayerTwo)
                .build();

        // when
        when(mockGameService.retrieveGameById(4711L))
                .thenReturn(stubbedGame);
        final var request = MockMvcRequestBuilders
                .get("/api/games/4711");
        final var response = assertDoesNotThrow(() -> mockMvc.perform(request));

        // then
        assertDoesNotThrow(() -> {
            response.andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                    // TODO create json
                    //  .andExpect(content().json(expectedGameAsJson, true));
        });
    }

    // @Test
    @DisplayName("should return 404 not found for retrieve game with id 0")
    void shouldReturn404NotFoundForRetrieveGameById() {
        // given
        when(mockGameService.retrieveGameById(0L))
                .thenThrow(new GameNotFoundException("0L"));
        // when
        final var request = MockMvcRequestBuilders
                .get("/api/games/0");
        // then
        assertDoesNotThrow(() ->
            mockMvc.perform(request)
                .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json("{\"title\":\"0L\", \"invalidParameters\":null}", true)));
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}