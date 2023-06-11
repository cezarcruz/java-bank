package br.com.cezarcruz.javabank.gateway.out.schedule;

import br.com.cezarcruz.javabank.gateway.out.cache.redis.RedisCacheWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateCacheSchedulerTest {

    @Mock
    private RedisCacheWrapper redisCache;

    @InjectMocks
    private UpdateCacheScheduler updateCacheScheduler;

    @Test
    void justRun() {
        doNothing().when(redisCache).put(any());
        updateCacheScheduler.run();

        verify(redisCache).put(any());
    }

}