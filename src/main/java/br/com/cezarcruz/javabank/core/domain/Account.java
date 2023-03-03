package br.com.cezarcruz.javabank.core.domain;

import lombok.Builder;
import lombok.With;

@Builder(toBuilder = true)
public record Account(
        @With
    String internalId,
    String document,
    Integer accountNumber,
    String agency,
    AccountStatus status) {}
