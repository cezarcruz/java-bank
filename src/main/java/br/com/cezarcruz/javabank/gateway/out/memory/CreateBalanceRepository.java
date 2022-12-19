package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.Balance;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreateBalanceRepository implements CreateBalanceGateway {

    private final List<Balance> balances = new ArrayList<>();

    @Override
    public void create(final Account account) {

        final Balance balance = Balance.builder()
            .account(account)
            .build();

        balances.add(balance);
    }

}
