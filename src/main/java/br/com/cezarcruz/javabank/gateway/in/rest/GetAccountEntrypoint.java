package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.GetAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetAccountEntrypoint {

    private final GetAccountUseCase getAccountUseCase;

    public Mono<ServerResponse> getBy(final String internalId) {
        return getAccountUseCase.getBy(internalId)
            .map(account -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(account)))
            .orElseThrow();
    }

    public Mono<ServerResponse> getAll() {
        return getAccountUseCase.getAll()
            .flatMap(accounts -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(accounts)));
    }
}

