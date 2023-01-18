package de.leidenheit.plebdarts.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum CheckoutAlias {

    ALIAS_170(170, "Big Fish"),
    ALIAS_D1(2, "Mad House"),
    ALIAS_D3(6, "Babytops"),
    ALIAS_D20(40, "Tops");

    private final int score;
    private final String alias;

    public static Stream<CheckoutAlias> stream() {
        return Stream.of(CheckoutAlias.values());
    }

    public static CheckoutAlias findAliasForCheckoutScore(int score) {
        return CheckoutAlias.stream()
                .filter(checkoutAlias -> score == checkoutAlias.getScore())
                .findFirst()
                .orElse(null);
    }
}
