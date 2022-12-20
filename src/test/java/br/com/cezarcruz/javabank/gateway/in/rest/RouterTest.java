package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//DUMMY
@SpringBootTest
class RouterTest {

    @Autowired
    private Router router;

    @MockBean
    private StartAccountCreation startAccountCreation;

    @Test
    void whenCreatingNewAccount() {

        when(startAccountCreation.create(any())).thenReturn(Mono.empty());

        final WebTestClient client = WebTestClient
            .bindToRouterFunction(router.composedRoutes())
            .build();

        final String request = """
            {
                "agency": 1,
                "document": "123"
            }
            """;

        client.post()
            .uri("/account")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(request), String.class)
            .exchange()
            .expectStatus()
            .isAccepted();

        verify(startAccountCreation, times(1)).create(any());

    }

    @Test
    void whenSendingInvalidPayloadToCreateAccount() {

        final WebTestClient client = WebTestClient
            .bindToRouterFunction(router.composedRoutes())
            .build();

        final String request = """
            {
                "agency": 1
            }
            """;

        client.post()
            .uri("/account")
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(request), String.class)
            .exchange()
            .expectStatus()
            .isBadRequest();

        verify(startAccountCreation, times(0)).create(any());
    }

    @Test
    void whenGettingAllAccounts() {

        final WebTestClient client = WebTestClient
            .bindToRouterFunction(router.composedRoutes())
            .build();

        client.get()
            .uri("/account")
            .exchange()
            .expectStatus()
            .isOk();


    }

    @Test
    void whenGettingOneAccount() {

        final WebTestClient client = WebTestClient
            .bindToRouterFunction(router.composedRoutes())
            .build();

        client.get()
            .uri("/account/123")
            .exchange()
            .expectStatus()
            .isOk();

    }


}