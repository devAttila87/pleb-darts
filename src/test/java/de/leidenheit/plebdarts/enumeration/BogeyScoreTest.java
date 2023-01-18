package de.leidenheit.plebdarts.enumeration;

import de.leidenheit.plebdarts.common.enumeration.BogeyScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BogeyScoreTest {

    @Test
    @DisplayName("should find 7 bogey numbers")
    void shouldCount7Entries() {
        // given
        // when
        final var countOfEntries = BogeyScore.stream().count();
        // then
        assertEquals(7, countOfEntries);
    }

    @Test
    @DisplayName("should determine 168 as bogey")
    void shouldDetermine168AsBogeyScore() {
        // given
        final var scoreToCheck = 168;
        // when
        final var isBogey = BogeyScore.isBogeyScore(scoreToCheck);
        // then
        assertTrue(isBogey);
    }

    @Test
    @DisplayName("should determine 170 as non-bogey")
    void shouldDetermine170AsNonBogeyScore() {
        // given
        final var scoreToCheck = 170;
        // when
        final var isBogey = BogeyScore.isBogeyScore(scoreToCheck);
        // then
        assertFalse(isBogey);
    }
}