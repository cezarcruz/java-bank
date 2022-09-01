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

    @Bean
    public DefaultErrorHandler defaultErrorHandler(final KafkaOperations<Object, Object> operations) {
        var recover = new DeadLetterPublishingRecoverer(operations,
                (cr, e) -> new TopicPartition(cr.topic() + ".DLQ", 0));

        var exponentialBackOff = new ExponentialBackOffWithMaxRetries(3);
        exponentialBackOff.setInitialInterval(1000);
        exponentialBackOff.setMultiplier(1.5);
        exponentialBackOff.setMaxInterval(2000);

        //errorHandler.addNotRetryableExceptions(javax.validation.ValidationException.class);

        return new DefaultErrorHandler(recover, exponentialBackOff);
    }

}
