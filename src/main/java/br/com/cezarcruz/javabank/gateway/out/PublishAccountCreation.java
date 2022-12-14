package br.com.cezarcruz.javabank.gateway.out;

import br.com.cezarcruz.javabank.core.domain.Account;
import reactor.core.publisher.Mono;

public interface PublishAccountCreation {
    Mono<Void> create(final Account account);
}
