package de.leidenheit.plebdarts.resource.api.game;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Contains personal statistics.")
@Data
@Builder(setterPrefix = "set")
public class PersonalStatisticsResource {

    @Schema(description = "Amount of games played.", example = "42")
    @Min(value = 0)
    private int gamesPlayed;

    @Schema(description = "Amount of games won.", example = "21")
    @Min(value = 0)
    private int gamesWon;

    @Schema(description = "Amount of 180s thrown.", example = "1")
    @Min(value = 0)
    private int countOf180s;

    @Schema(description = "Amount of darts thrown.", example = "21000000")
    @Min(value = 0)
    private int thrownDarts;

    @Schema(description = "Average score per single dart.", example = "10.5")
    @Min(value = 0)
    private double avgPerDart;

    @Schema(description = "Average score per leg.", example = "32.5")
    @Min(value = 0)
    private double avgPerLeg;
}
