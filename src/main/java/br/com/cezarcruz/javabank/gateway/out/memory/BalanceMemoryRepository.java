package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.Balance;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import br.com.cezarcruz.javabank.gateway.out.GetBalanceGateway;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalanceMemoryRepository implements CreateBalanceGateway, GetBalanceGateway {

    private final List<Balance> balances = new ArrayList<>();

    @Override
    public void create(final Account account) {

        final Balance balance = Balance.builder()
            .account(account)
            .build();

        balances.add(balance);
    }

    @Override
    public Optional<Balance> get(final Account account) {
        return balances.stream()
            .filter(balance -> balance.account().internalId().equals(account.internalId()))
            .findFirst();
    }

}
