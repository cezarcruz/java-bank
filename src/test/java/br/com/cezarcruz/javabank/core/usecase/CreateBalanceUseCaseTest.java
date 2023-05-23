package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBalanceUseCaseTest {

    @Mock
    private CreateBalanceGateway createBalance;

    @InjectMocks
    private CreateBalanceUseCase createBalanceUseCase;

    @Test
    void shouldCreate() {
        final Account account = AccountFactory.generateActiveAccount();
        createBalanceUseCase.create(account);

        verify(createBalance).create(any());
    }

}