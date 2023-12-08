package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import org.springframework.stereotype.Component;

@Component
public class CreateBalanceUseCase {

    private final CreateBalanceGateway createBalance;

    public CreateBalanceUseCase(final CreateBalanceGateway createBalance) {
        this.createBalance = createBalance;
    }

    public void create(final Account account) {
        createBalance.create(account);
    }

}
