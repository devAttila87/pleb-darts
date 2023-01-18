package de.leidenheit.plebdarts.enumeration;

import de.leidenheit.plebdarts.common.enumeration.CheckoutAlias;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutAliasTest {

    @Test
    @DisplayName("should find 4 checkout alias")
    void shouldCount7Entries() {
        // given
        // when
        final var countOfEntries = CheckoutAlias.stream().count();
        // then
        assertEquals(4, countOfEntries);
    }

    @Test
    @DisplayName("should retrieve alias BigFish for score 170")
    void shouldRetrieveAliasBigFishForScore170() {
        // given
        final var expectedCheckoutAlias = "Big Fish";
        // when
        final var checkoutAlias = CheckoutAlias.findAliasForCheckoutScore(170);
        // then
        assertEquals(expectedCheckoutAlias, checkoutAlias.getAlias());
    }

    @Test
    @DisplayName("should retrieve no alias for score 60")
    void shouldRetrieveNullForScore60() {
        // given
        final var scoreToCheck = 60;
        // when
        final var checkoutAlias = CheckoutAlias.findAliasForCheckoutScore(scoreToCheck);
        // then
        assertNull(checkoutAlias);
    }
}