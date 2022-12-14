package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.accepted;

@Configuration(proxyBeanMethods = false)
public class Router {

    @Bean
    public RouterFunction<ServerResponse> getAccountRoute(final GetAccountEntrypoint getAccountEntrypoint) {
        return RouterFunctions
            .route(
                GET("/account/{internalId}").and(accept(MediaType.APPLICATION_JSON)),
                req -> {
                    final String internalId = req.pathVariable("internalId");
                    return getAccountEntrypoint.getBy(internalId);
                });
    }

    @Bean
    public RouterFunction<ServerResponse> createAccount(final CreateAccountEntrypoint createAccountEntrypoint) {
        return RouterFunctions
            .route(
                POST("/account").and(accept(MediaType.APPLICATION_JSON)),
                req -> {
                    return req.bodyToMono(CreateAccountRequest.class)
                        .doOnNext(createAccountEntrypoint::create)
                        .then(accepted().build());
                });
    }

}
