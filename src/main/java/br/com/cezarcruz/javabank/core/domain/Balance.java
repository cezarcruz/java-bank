package br.com.cezarcruz.javabank.core.domain;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Balance(
    Account account,
    BigDecimal amount
) {

    public Balance {
        if (amount == null) {
            amount = BigDecimal.ZERO;
        }
    }

}
