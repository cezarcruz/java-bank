package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateAccountUseCaseTest {
    
    @Spy
    private AccountGeneratorUseCase accountGeneratorUseCase;

    @Mock
    private CreateAccountGateway accountMemoryRepository;

    @InjectMocks
    private CreateAccountUseCase createAccountUseCase;

    @Test
    void shouldCreate() {
        final Account account = AccountFactory.generateActiveAccount();
        createAccountUseCase.create(account);

        verify(accountMemoryRepository).create(any());
    }

}