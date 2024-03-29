package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAccountUseCase {

    private final GetAccountGateway getAccountGateway;

    public GetAccountUseCase(final GetAccountGateway getAccountGateway) {
        this.getAccountGateway = getAccountGateway;
    }

    public Optional<Account> getBy(final String internalId) {
        return getAccountGateway.getBy(internalId);
    }

    public List<Account> getAll() {
        return getAccountGateway.getAll();
    }

}
