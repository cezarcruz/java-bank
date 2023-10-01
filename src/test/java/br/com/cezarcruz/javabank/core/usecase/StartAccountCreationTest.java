package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class StartAccountCreationTest {

    @Mock
    private CreateAccountUseCase createAccountUseCase;

    @InjectMocks
    private StartAccountCreation startAccountCreation;


    @Test
    void shouldStartAnAccountCreation() {

        final Account account = AccountFactory.generatePendingAccount();
        doNothing().when(createAccountUseCase).create(account);

        startAccountCreation.create(account);

        verify(createAccountUseCase).create(account);
    }

}