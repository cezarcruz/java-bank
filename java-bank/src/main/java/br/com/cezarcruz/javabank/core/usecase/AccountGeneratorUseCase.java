package br.com.cezarcruz.javabank.core.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class AccountGeneratorUseCase {

    public Integer generate(final String agency) {
        log.info("generating account to agency {}", agency);
        return new Random().nextInt(10_000);
    }

}
