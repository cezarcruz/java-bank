package br.com.cezarcruz.javabank.gateway.in.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateAccountListener {

    @KafkaListener(topics = "topic1")
    public void listen(final Account data) {
        log.info("receiving account {}", data);
    }

}
