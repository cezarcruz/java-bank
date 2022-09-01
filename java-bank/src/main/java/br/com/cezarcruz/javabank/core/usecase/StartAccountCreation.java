package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartAccountCreation {

    private final PublishAccountCreation publishAccountCreation;
    private final CreateAccountGateway createAccountMemoryRepository;

    public void create(final Account account) {

        final Account pendingAccount =
                account.toBuilder()
                    .status(AccountStatus.PENDING)
                        .build();

        createAccountMemoryRepository.create(pendingAccount);
        //TODO: may change to notify
        publishAccountCreation.create(pendingAccount);
    }
}
