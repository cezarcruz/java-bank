package br.com.cezarcruz.javabank.gateway.out.memory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountMemoryRepository implements CreateAccountGateway, GetAccountGateway {

    private static final Set<Account> db = new HashSet<>();

    private final KafkaTemplate<String, Account> kafkaTemplate;

    @Override
    public Account create(final Account account) {

        final Account accountWithId = account.toBuilder()
                .internalId(UUID.randomUUID().toString())
                .build();

        db.add(accountWithId);
        kafkaTemplate.send("topic1", UUID.randomUUID().toString(), accountWithId);

        return accountWithId;
    }

    @Override
    public Optional<Account> getBy(final String internalId) {
        return db.stream()
                .filter(a -> a.getInternalId().equals(internalId))
                .findFirst();
    }
}
