package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateAccountUseCase {

    private final AccountGeneratorUseCase accountGeneratorUseCase;
    private final CreateAccountGateway accountMemoryRepository;

    public CreateAccountUseCase(final AccountGeneratorUseCase accountGeneratorUseCase,
                                final CreateAccountGateway accountMemoryRepository) {
        this.accountGeneratorUseCase = accountGeneratorUseCase;
        this.accountMemoryRepository = accountMemoryRepository;
    }

    public void create(final Account account) {

        final Account accountWithAccountNumber = account.toBuilder()
            .accountNumber(accountGeneratorUseCase.generate(account.agency()))
            .internalId(UUID.randomUUID().toString())
            .status(AccountStatus.ACTIVE)
            .build();

        accountMemoryRepository.create(accountWithAccountNumber);
    }

}
