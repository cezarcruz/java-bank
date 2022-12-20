package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.CreateBalanceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateBalanceUseCase {

    private final CreateBalanceGateway createBalance;

    public void create(final Account account) {
        createBalance.create(account);
    }

}
