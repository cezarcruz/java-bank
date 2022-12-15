package br.com.cezarcruz.javabank.gateway.in.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateAccountListener {

    private final CreateAccountUseCase createAccountUseCase;

    @KafkaListener(topics = "${topics.create-account}")
    public void listen(final Account data) {
        log.info("receiving account {}", data);

        createAccountUseCase.create(data);

    }

}
