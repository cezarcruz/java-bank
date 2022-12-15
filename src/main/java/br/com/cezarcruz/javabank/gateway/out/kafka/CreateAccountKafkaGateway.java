package br.com.cezarcruz.javabank.gateway.out.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateAccountKafkaGateway implements PublishAccountCreation {

    private final KafkaTemplate<String, Account> kafkaTemplate;

    @Value("${topics.create-account}")
    private String topic;

    @Override
    public Mono<Void> create(final Account account) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), account);
        return Mono.empty();
    }

}
