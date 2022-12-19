package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.Balance;

import java.util.Optional;

public interface GetBalanceGateway {
    Optional<Balance> get(final Account account);
}
