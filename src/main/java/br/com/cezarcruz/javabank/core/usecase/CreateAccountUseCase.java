package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAccountUseCase {

    private final AccountGeneratorUseCase accountGeneratorUseCase;
    private final CreateAccountGateway accountMemoryRepository;

    public void create(final String agency) {

        final Account accountWithAccountNumber = Account.builder()
                .account(accountGeneratorUseCase.generate(agency))
                .agency(agency)
                .build();

        accountMemoryRepository.create(accountWithAccountNumber);
    }

}
