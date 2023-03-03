package br.com.cezarcruz.javabank.gateway.out.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountKafkaGateway implements PublishAccountCreation {

    private final KafkaTemplate<String, Account> kafkaTemplate;

    @Value("${topics.create-account}")
    private String topic;

    @Override
    public void create(final Account account) {
        kafkaTemplate.send(topic, account);
    }

}
