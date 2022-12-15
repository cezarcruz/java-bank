package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateAccountEntrypoint {

    private final StartAccountCreation startAccountCreation;

    public Mono<Void> create(final CreateAccountRequest request) {

        return Mono.just(request)
            .map(r -> Account.builder()
                .agency(r.agency())
                .document(r.document())
                .build())
                .flatMap(startAccountCreation::create);
    }

}
