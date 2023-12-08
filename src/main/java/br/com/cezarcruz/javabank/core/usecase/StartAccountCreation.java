package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class StartAccountCreation {

    private final CreateAccountUseCase createAccountUseCase;

    public StartAccountCreation(final CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    //pretend this will have some logic in future
    public void create(final Account account) {
        createAccountUseCase.create(account);
    }
}
