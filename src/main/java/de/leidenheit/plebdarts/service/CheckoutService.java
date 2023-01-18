package de.leidenheit.plebdarts.service;

import de.leidenheit.plebdarts.exception.CheckoutPathNotFoundException;
import de.leidenheit.plebdarts.resource.entity.game.CheckoutPath;
import de.leidenheit.plebdarts.repository.CheckoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final CheckoutRepository checkoutRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutService.class);

    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public CheckoutPath determineCheckoutPathFor(int score) throws CheckoutPathNotFoundException {
        final var checkout = this.checkoutRepository.findByScore(score);
        if (checkout == null) {
            LOGGER.error("Could not determine checkout path for score {}", score);
            throw new CheckoutPathNotFoundException("Could not find any checkout path for score " + score);
        }
        LOGGER.info("Determined checkout path for score {} as \"{}\"", score, checkout.getPath());
        return checkout;
    }
}
