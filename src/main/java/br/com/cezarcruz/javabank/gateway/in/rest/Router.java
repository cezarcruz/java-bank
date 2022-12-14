package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.accepted;

@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class Router {

    private final GetAccountEntrypoint getAccountEntrypoint;
    private final CreateAccountEntrypoint createAccountEntrypoint;

    @Bean
    public RouterFunction<ServerResponse> composedRoutes() {
        return
            route(GET("/account/{internalId}").and(accept(MediaType.APPLICATION_JSON)), this::getAccountById)
            .and(route(POST("/account").and(accept(MediaType.APPLICATION_JSON)), this::createAccount));
    }

    private Mono<ServerResponse> createAccount(final ServerRequest req) {
        return req.bodyToMono(CreateAccountRequest.class)
            .doOnNext(createAccountEntrypoint::create)
            .then(accepted().build());
    }

    private Mono<ServerResponse> getAccountById(final ServerRequest req) {
        final String internalId = req.pathVariable("internalId");
        return getAccountEntrypoint.getBy(internalId);
    }

}
