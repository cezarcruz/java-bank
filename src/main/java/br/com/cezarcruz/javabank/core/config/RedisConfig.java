package br.com.cezarcruz.javabank.core.config;


import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class RedisConfig {


    @Bean
    public LettuceConnectionFactory redisConnectionFactory(final RedisConfiguration redisConfiguration) {

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(ReadFrom.REPLICA_PREFERRED).build();

        return new LettuceConnectionFactory(redisConfiguration, clientConfig);
    }

    @Bean
    public RedisConfiguration redisConfiguration() {
        return new RedisStandaloneConfiguration();
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    @Primary
    public RedisTemplate<String, LocalDateTime> redisTemplate(final RedisConnectionFactory connectionFactory) {
        final RedisTemplate<String, LocalDateTime> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
}


