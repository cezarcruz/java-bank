package br.com.cezarcruz.javabank.gateway.out.schedule;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
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
    private final StartAccountCreation startAccountCreation;

    @Scheduled(fixedDelay = 10000)
    void run() {
      log.info("running");
      restTemplate.opsForValue()
              .append(LocalDateTime.now().toString(), LocalDateTime.now().toString());
      //startAccountCreation.create(Account.builder().agency("1000").build()).subscribe();
    }

}
