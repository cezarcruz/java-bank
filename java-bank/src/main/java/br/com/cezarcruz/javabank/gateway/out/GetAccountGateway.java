package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;

import java.util.Optional;

public interface GetAccountGateway {
    Optional<Account> getBy(final String internalId);
}
