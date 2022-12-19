package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.Balance;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import br.com.cezarcruz.javabank.gateway.out.GetBalanceGateway;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class CreateBalanceRepositoryTest {

    @Test
    void createBalance() {
        final CreateBalanceGateway createBalanceRepository = new BalanceMemoryRepository();
        final Account account = Account.builder().internalId(UUID.randomUUID().toString()).build();
        createBalanceRepository.create(account);

        final GetBalanceGateway balanceGateway = (GetBalanceGateway) createBalanceRepository;

        final Optional<Balance> balance = balanceGateway.get(account);

        assertThat(balance.isEmpty(), is(false));
        assertThat(balance.get(), not(nullValue()));
    }

}