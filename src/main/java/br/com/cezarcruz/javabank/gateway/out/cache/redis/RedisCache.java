package br.com.cezarcruz.javabank.gateway.out.cache.redis;

import br.com.cezarcruz.javabank.gateway.out.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RedisCache implements Cache {

    private final RedisTemplate<String, LocalDateTime> redisTemplate;

    @Override
    public void put(final String key) {
        redisTemplate.opsForValue()
                .append(key, LocalDateTime.now().toString());
    }
}
