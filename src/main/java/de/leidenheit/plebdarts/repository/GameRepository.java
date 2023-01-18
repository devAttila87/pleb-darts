package de.leidenheit.plebdarts.repository;

import de.leidenheit.plebdarts.resource.entity.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}