package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface GetAccountGateway {
    Optional<Account> getBy(final String internalId);

    Mono<List<Account>> getAll();
}
