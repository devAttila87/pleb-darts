package de.leidenheit.plebdarts.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.leidenheit.plebdarts.resource.api.game.CreateGameResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Dummy shouldReturn201CreatedForOpCreateGame")
    void shouldReturn201CreatedForOpCreateGame() {
        // given
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

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}