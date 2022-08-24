package br.com.cezarcruz.javabank.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Account {
    private String internalId;
    private Integer account;
    private String agency;
}
