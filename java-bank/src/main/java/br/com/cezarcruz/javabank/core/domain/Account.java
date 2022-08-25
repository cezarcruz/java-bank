package br.com.cezarcruz.javabank.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor //TODO: remove
@NoArgsConstructor
@ToString
public class Account {
    private String internalId;
    private Integer account;
    private String agency;

    private AccountStatus status;
}
