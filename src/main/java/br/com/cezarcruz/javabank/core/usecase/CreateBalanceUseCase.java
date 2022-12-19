package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.memory.CreateBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateBalanceUseCase {

    private final CreateBalanceRepository createBalanceRepository;

    public void create(final Account account) {
        createBalanceRepository.create(account);
    }

}
