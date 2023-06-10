package br.com.cezarcruz.javabank.gateway.out.schedule;

import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.out.cache.Cache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCacheScheduler {

    private final Cache cache;
    private final StartAccountCreation startAccountCreation;

    @Scheduled(fixedDelay = 10000)
    void run() {
      log.info("running");
      cache.put(LocalDateTime.now().toString());
      //startAccountCreation.create(Account.builder().agency("1000").build()).subscribe();
    }

}
