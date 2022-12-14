package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class RouterTest {

    @Autowired
    private Router router;

    @MockBean
    private StartAccountCreation startAccountCreation;

    @Test
    void whenCreatingNewAccount() {

        final WebTestClient client = WebTestClient
            .bindToRouterFunction(router.composedRoutes())
            .build();

        final CreateAccountRequest request = new CreateAccountRequest("001");

        client.post()
            .uri("/account")
            .body(Mono.just(request), CreateAccountRequest.class)
            .exchange()
            .expectStatus()
            .isAccepted();

        verify(startAccountCreation, times(1)).create(any());

    }

}