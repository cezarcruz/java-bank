package br.com.cezarcruz.javabank.gateway.in.kafka;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.ExponentialBackOffWithMaxRetries;

@Configuration
public class KafkaErrorHandler {

    private static final String DLQ_POS_FIX = ".DLQ";

    @Bean
    public DefaultErrorHandler defaultErrorHandler(final KafkaOperations<Object, Object> operations) {
        var recover = new DeadLetterPublishingRecoverer(operations,
                (cr, e) -> new TopicPartition(cr.topic() + DLQ_POS_FIX, 0));

        var exponentialBackOff = new ExponentialBackOffWithMaxRetries(3);
        exponentialBackOff.setInitialInterval(1_000);
        exponentialBackOff.setMultiplier(1.5);
        exponentialBackOff.setMaxInterval(2_000);

        return new DefaultErrorHandler(recover, exponentialBackOff);
    }

}
