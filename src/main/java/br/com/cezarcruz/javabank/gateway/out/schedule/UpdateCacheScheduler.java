package br.com.cezarcruz.javabank.gateway.out.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCacheScheduler {

    private final RedisTemplate<String, LocalDateTime> restTemplate;

    @Scheduled(fixedDelay = 500)
    void run() {
      log.info("running");
      restTemplate.opsForValue().append(LocalDateTime.now().toString(), LocalDateTime.now().toString());
    }

}
