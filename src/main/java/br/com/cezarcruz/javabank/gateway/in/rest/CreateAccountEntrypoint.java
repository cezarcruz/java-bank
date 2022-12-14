package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateAccountEntrypoint {

    private final StartAccountCreation startAccountCreation;

    public Mono<ServerResponse> create(final CreateAccountRequest request) {

        final Account account =
                Account.builder()
                        .agency(request.getAgency())
                        .build();

        startAccountCreation.create(account);
        return Mono.empty();
    }

}
