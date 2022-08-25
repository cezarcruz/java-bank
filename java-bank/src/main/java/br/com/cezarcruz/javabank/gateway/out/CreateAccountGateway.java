package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;

public interface CreateAccountGateway {
    Account create(final Account account);
}
