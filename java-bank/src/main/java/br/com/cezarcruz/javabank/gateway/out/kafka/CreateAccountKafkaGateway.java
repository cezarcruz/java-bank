package br.com.cezarcruz.javabank.gateway.out.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateAccountKafkaGateway implements PublishAccountCreation {

    private final KafkaTemplate<String, Account> kafkaTemplate;

    @Override
    public void create(final Account account) {
        kafkaTemplate.send("topic1", UUID.randomUUID().toString(), account);
    }

}
