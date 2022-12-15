package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StartAccountCreation {

    private final PublishAccountCreation publishAccountCreation;

    public Mono<Void> create(final Account account) {
        return Mono.just(account)
            .flatMap(publishAccountCreation::create);
    }
}
