package br.com.cezarcruz.javabank.itegration;


import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import br.com.cezarcruz.javabank.gateway.out.mongo.AccountMongoGateway;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateAccountTest {

    @Container
    @ServiceConnection
    static MongoDBContainer mongodb = new MongoDBContainer("mongo:5.0");

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AccountMongoGateway accountMongoRepository;

    @Test
    @Order(1)
    void createAccount() {

        final var request = new CreateAccountRequest("0001", "12332112300");

        final ResponseEntity<Void> result = testRestTemplate.postForEntity("/account", request, Void.class);

        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

        long count = accountMongoRepository.getAll().size();
        Assertions.assertEquals(1, count);

    }

}
