package de.leidenheit.plebdarts.resource.api.game;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Contains information about a player.")
@Data
@Builder(setterPrefix = "set")
public class PlayerReadResource {

    @Schema(description = "The technical identifier of the player.", example = "4711")
    private long id;

    private PersonalInfoResource personalInfo;
    private PersonalStatisticsResource personalStatistics;
}
