package br.com.cezarcruz.javabank.core.domain;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Account {
    private String internalId;
    private String document;
    private Integer accountNumber;
    private String agency;
    private AccountStatus status;
}
