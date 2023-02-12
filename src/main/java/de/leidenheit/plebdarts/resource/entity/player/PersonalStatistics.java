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

    private int gamesPlayed;
    private int gamesWon;
    private int countOf180s;
    private int thrownDarts;
    private double avgPerDart;
    private double avgPerLeg;
}
