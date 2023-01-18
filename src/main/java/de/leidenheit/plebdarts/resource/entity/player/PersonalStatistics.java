package de.leidenheit.plebdarts.resource.entity.player;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
@Embeddable
public class PersonalStatistics {

    protected int gamesPlayed;
    protected int gamesWon;
    protected int countOf180s;
    protected int thrownDarts;
    protected double avgPerDart;
    protected double avgPerLeg;
}
