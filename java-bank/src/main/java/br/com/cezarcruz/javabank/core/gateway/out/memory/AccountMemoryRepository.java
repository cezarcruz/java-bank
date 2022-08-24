package br.com.cezarcruz.javabank.core.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.gateway.out.CreateAccountGateway;
import br.com.cezarcruz.javabank.core.gateway.out.GetAccountGateway;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class AccountMemoryRepository implements CreateAccountGateway, GetAccountGateway {

    private final Set<Account> db = new HashSet<>();

    @Override
    public Account create(final Account account) {

        final Account accountWithId = account.toBuilder()
                .internalId(UUID.randomUUID().toString())
                .build();

        db.add(accountWithId);

        return accountWithId;
    }

    @Override
    public Optional<Account> getBy(final String internalId) {
        return db.stream()
                .filter(a -> a.getInternalId().equals(internalId))
                .findFirst();
    }
}
