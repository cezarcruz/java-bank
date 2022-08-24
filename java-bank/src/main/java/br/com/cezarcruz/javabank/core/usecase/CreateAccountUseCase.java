package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateAccountUseCase {

    private final AccountGeneratorUseCase accountGeneratorUseCase;

    public Account create(final String agency) {
        return Account.builder()
                .account(accountGeneratorUseCase.generate(agency))
                .agency(agency)
                .internalId(UUID.randomUUID().toString())
                .build();
    }

}
