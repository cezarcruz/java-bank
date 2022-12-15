package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAccountUseCase {

    private final AccountGeneratorUseCase accountGeneratorUseCase;
    private final CreateAccountGateway accountMemoryRepository;

    public void create(final Account account) {

        final Account accountWithAccountNumber = account.toBuilder()
            .accountNumber(accountGeneratorUseCase.generate(account.agency()))
            .status(AccountStatus.ACTIVE)
            .build();

        accountMemoryRepository.create(accountWithAccountNumber);
    }

}
