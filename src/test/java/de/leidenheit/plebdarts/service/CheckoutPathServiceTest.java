package de.leidenheit.plebdarts.service;

import de.leidenheit.plebdarts.exception.CheckoutPathNotFoundException;
import de.leidenheit.plebdarts.resource.entity.game.CheckoutPath;
import de.leidenheit.plebdarts.repository.CheckoutRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CheckoutPathServiceTest {

    @MockBean
    private CheckoutRepository mockCheckoutRepository;
    @Autowired
    private CheckoutService underTest;

    private static final String CHECKOUT_PATH_100 = "T20 D20";
    private static final String CHECKOUT_PATH_170 = "T20 T20 Bullseye";

    private static final String ERR_MSG_INVALID_SCORE_4711 = "Could not find any checkout path for score 4711";

    @Test
    @DisplayName("should determine checkout paths for the scores 100 and 170")
    void shouldDetermineCheckoutForScore100And170() {
        // given
        when(mockCheckoutRepository.findByScore(100))
                .thenReturn(new CheckoutPath(100, CHECKOUT_PATH_100));
        when(mockCheckoutRepository.findByScore(170))
                .thenReturn(new CheckoutPath(170, CHECKOUT_PATH_170));
        // when
        final var checkout100 = this.underTest.determineCheckoutPathFor(100);
        final var checkout170 = this.underTest.determineCheckoutPathFor(170);
        // then
        verify(mockCheckoutRepository, times(1)).findByScore(100);
        verify(mockCheckoutRepository, times(1)).findByScore(170);
        assertNotNull(checkout100);
        assertEquals(CHECKOUT_PATH_100, checkout100.getPath());
        assertNotNull(checkout170);
        assertEquals(CHECKOUT_PATH_170, checkout170.getPath());
    }

    @Test
    @DisplayName("should throw when retrieving null checkout paths for invalid score 4711")
    void shouldThrowWhenRetrievingNullCheckoutForInvalidScore4711() {
        // given
        when(mockCheckoutRepository.findByScore(4711))
                .thenReturn(null);
        // when
        final var exception = assertThrowsExactly(CheckoutPathNotFoundException.class, ()-> {
            this.underTest.determineCheckoutPathFor(4711);
        });
        // then
        verify(mockCheckoutRepository, times(1)).findByScore(4711);
        assertNotNull(exception);
        assertEquals(ERR_MSG_INVALID_SCORE_4711, exception.getMessage());
    }
}
