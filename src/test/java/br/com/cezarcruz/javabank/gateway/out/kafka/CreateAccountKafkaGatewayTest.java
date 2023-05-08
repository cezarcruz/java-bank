package br.com.cezarcruz.javabank.gateway.out.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAccountKafkaGatewayTest {

    private static final String TOPIC = "topic";

    @Mock
    private KafkaTemplate<String, Account> kafkaTemplate;

    @InjectMocks
    private CreateAccountKafkaGateway createAccountKafkaGateway;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(createAccountKafkaGateway, TOPIC, TOPIC);
    }

    @Test
    void shouldSendToKafka() {
        final Account account = AccountFactory.generatePendingAccount();
        when(kafkaTemplate.send(TOPIC, account)).thenReturn(null);

        createAccountKafkaGateway.create(account);

        verify(kafkaTemplate).send(TOPIC, account);
    }

}