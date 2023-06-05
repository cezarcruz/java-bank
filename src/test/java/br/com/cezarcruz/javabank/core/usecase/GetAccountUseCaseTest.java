package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAccountUseCaseTest {

    @Mock
    private GetAccountGateway getAccountGateway;

    @InjectMocks
    private GetAccountUseCase getAccountUseCase;

    @Test
    void shouldGetById() {
        final var internalId = UUID.randomUUID().toString();

        when(getAccountGateway.getBy(internalId))
                .thenReturn(Optional.of(Account.builder().build()));

        final Optional<Account> account = getAccountUseCase.getBy(internalId);

        Assertions.assertTrue(account.isPresent());
        assertNotNull(account.get());
    }

    @Test
    void shouldGetAll() {
        when(getAccountGateway.getAll()).thenReturn(List.of(Account.builder().build()));

        final var accountList = getAccountUseCase.getAll();

        assertNotNull(accountList);
        assertEquals(1, accountList.size());

    }

}