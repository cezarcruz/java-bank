package br.com.cezarcruz.javabank.gateway.out.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCacheScheduler {

    @Scheduled(fixedDelay = 10000)
    void run() {
      log.info("running");
    }

}
