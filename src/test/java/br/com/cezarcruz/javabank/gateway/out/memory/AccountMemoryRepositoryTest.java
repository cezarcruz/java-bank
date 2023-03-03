package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class AccountMemoryRepositoryTest {


    @DisplayName("Should test all repository at once")
    @Test
    void shouldTestAllRepositoryAtOnce() {

        final AccountMemoryRepository accountMemoryRepository = new AccountMemoryRepository();

        assertThat(accountMemoryRepository.getAll(), hasSize(0));

        final Account account = AccountFactory.generateAccount();
        accountMemoryRepository.create(account);

        assertThat(accountMemoryRepository.getAll(), hasSize(1));

        final Optional<Account> foundAccount = accountMemoryRepository.getBy(account.internalId());

        assertThat(foundAccount.isPresent(), is(true));
        assertThat(foundAccount.get().accountNumber(), is(account.accountNumber()));

    }
}