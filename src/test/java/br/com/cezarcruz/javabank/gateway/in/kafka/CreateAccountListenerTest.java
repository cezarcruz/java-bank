package br.com.cezarcruz.javabank.gateway.in.kafka;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.CreateAccountUseCase;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateAccountListenerTest {

    @Mock
    private CreateAccountUseCase createAccountUseCase;

    @InjectMocks
    private CreateAccountListener createAccountListener;

    @Test
    void shouldListen() {
        final Account account = AccountFactory.generateActiveAccount();
        createAccountListener.listen(account);

        verify(createAccountUseCase).create(account);

    }

}