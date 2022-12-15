package br.com.cezarcruz.javabank.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String internalId;
    private String document;
    private Integer accountNumber;
    private String agency;
    private AccountStatus status;
}
