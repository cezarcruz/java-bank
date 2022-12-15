package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import br.com.cezarcruz.javabank.gateway.in.rest.validators.CreateAccountValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

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
        return route()
            .path("/account",
                builder -> builder
                    .POST(this::createAccount)
                    .GET(this::getAll)
                    .GET("/{internalId}", accept(MediaType.APPLICATION_JSON), this::getAccountById))
            .build();
    }

    private Mono<ServerResponse> createAccount(final ServerRequest req) {

        final CreateAccountValidator validator = new CreateAccountValidator();

        return req.bodyToMono(CreateAccountRequest.class)
            .map(body -> {
                final var errors = new BeanPropertyBindingResult(body, CreateAccountRequest.class.getName());
                validator.validate(body, errors);

                if (errors.getAllErrors().isEmpty()) {
                    return body;
                } else {
                    throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        errors.getAllErrors().toString()
                    );
                }

            })
            .flatMap(createAccountEntrypoint::create)
            .then(accepted().build());
    }

    private Mono<ServerResponse> getAccountById(final ServerRequest req) {
        final String internalId = req.pathVariable("internalId");
        return getAccountEntrypoint.getBy(internalId);
    }

    private Mono<ServerResponse> getAll(final ServerRequest req) {
        return getAccountEntrypoint.getAll();
    }

}
