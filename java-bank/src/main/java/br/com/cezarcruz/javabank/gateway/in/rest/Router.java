package br.com.cezarcruz.javabank.gateway.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class Router {

    private final GetAccountEntrypoint getAccountEntrypoint;

    @Bean
    public RouterFunction<ServerResponse> getAccountById() {
        return route(GET("/account/{internalId}"), req -> {
            final String internalId = req.pathVariable("internalId");
            return getAccountEntrypoint.getBy(internalId)
                    .map(a -> ok().body(a))
                    .orElseThrow(RuntimeException::new);
        });
    }

}
