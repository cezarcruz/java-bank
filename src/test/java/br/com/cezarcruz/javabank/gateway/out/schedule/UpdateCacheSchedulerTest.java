package br.com.cezarcruz.javabank.gateway.out.schedule;

import br.com.cezarcruz.javabank.gateway.out.cache.Cache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateCacheSchedulerTest {

    @Spy
    private Cache cache = new Cache() {
        @Override
        public void put(String key) {
            System.out.println(key);
        }
    };

    @InjectMocks
    private UpdateCacheScheduler updateCacheScheduler;

    @Test
    void justRun() {
        updateCacheScheduler.run();
    }

}