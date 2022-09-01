package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;

public interface PublishAccountCreation {
    void create(final Account account);
}
