package de.leidenheit.plebdarts.repository;

import de.leidenheit.plebdarts.resource.entity.game.CheckoutPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository
        extends JpaRepository<CheckoutPath, Integer> {

    CheckoutPath findByScore(int score);
}
