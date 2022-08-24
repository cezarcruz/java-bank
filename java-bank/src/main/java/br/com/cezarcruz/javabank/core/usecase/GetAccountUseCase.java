package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.gateway.out.GetAccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAccountUseCase {

    private final GetAccountGateway getAccountGateway;

    public Optional<Account> getBy(final String internalId) {
        return getAccountGateway.getBy(internalId);
    }

}
