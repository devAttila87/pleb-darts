package de.leidenheit.plebdarts.resource.entity.game;


import de.leidenheit.plebdarts.resource.entity.player.Player;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
@Entity
public class Game implements Playable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    protected int turns = 0;
    protected int dartCount = 0;
    protected GameStatus gameStatus = GameStatus.NEW;
    protected GameType gameType = GameType.GT_501;
    @OneToMany
    protected List<Player> players = new ArrayList<>();
    @OneToOne
    protected Player winner;

    @Override
    public GameType getGameType() {
        return gameType;
    }
}
