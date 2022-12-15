package br.com.cezarcruz.javabank.core.domain;

import lombok.Builder;

@Builder(toBuilder = true)
public record Account(
    String internalId,
    String document,
    Integer accountNumber,
    String agency,
    AccountStatus status) {}
