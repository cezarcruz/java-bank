package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartAccountCreation {

    private final CreateAccountUseCase createAccountUseCase;

    //pretend this will have some logic in future
    public void create(final Account account) {
        createAccountUseCase.create(account);
    }
}
