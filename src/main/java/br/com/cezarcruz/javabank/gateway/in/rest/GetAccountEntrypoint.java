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

//    public Optional<Account> getBy(final String internalId) {
//        return getAccountUseCase.getBy(internalId);
//    }

    public Mono<ServerResponse> getBy(final String internalId) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(getAccountUseCase.getBy(internalId)));
    }

}

