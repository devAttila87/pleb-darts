package de.leidenheit.plebdarts.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum BogeyScore {

    BOGEY_SCORE_169(169),
    BOGEY_SCORE_168(168),
    BOGEY_SCORE_166(166),
    BOGEY_SCORE_165(165),
    BOGEY_SCORE_163(163),
    BOGEY_SCORE_162(162),
    BOGEY_SCORE_159(159);

    private final int score;

    public static Stream<BogeyScore> stream() {
        return Stream.of(BogeyScore.values());
    }
    public static boolean isBogeyScore(int score) {
        return Stream.of(BogeyScore.values())
                .anyMatch(bogeyScore -> score == bogeyScore.getScore());
    }
}
