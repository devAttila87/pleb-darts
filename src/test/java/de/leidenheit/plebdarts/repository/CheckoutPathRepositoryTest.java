package de.leidenheit.plebdarts.repository;

import de.leidenheit.plebdarts.resource.entity.game.CheckoutPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class CheckoutPathRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CheckoutRepository underTest;

    private static final String CHECK_PATH_170 = "T20 T20 Bullseye";

    @BeforeEach
    void setUp() {
        testEntityManager.persist(new CheckoutPath(170, CHECK_PATH_170));
    }

    @Test
    @DisplayName("should find 3-darts checkout path for the Big Fish")
    void shouldFindThreeDartCheckoutForBigFish() {
        // given
        // when
        final var checkout = this.underTest.findByScore(170);
        // then
        assertNotNull(checkout);
        assertEquals(170, checkout.getScore());
        assertEquals(CHECK_PATH_170, checkout.getPath());
    }
}