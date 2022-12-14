package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountMemoryRepository implements CreateAccountGateway, GetAccountGateway {

    private static final List<Account> db = new ArrayList<>();

    @Override
    public Account create(final Account account) {

        if (AccountStatus.PENDING.equals(account.getStatus())) {
            db.add(account);
            return account;
        }

        final Account accountWithId = account.toBuilder()
                .internalId(UUID.randomUUID().toString())
                .build();

        log.info("account created {}", accountWithId);
        db.add(accountWithId);

        return accountWithId;
    }

    @Override
    public Optional<Account> getBy(final String internalId) {
        return db.stream()
                .filter(a -> internalId.equals(a.getInternalId()))
                .findFirst();
    }
}
