package br.com.cezarcruz.javabank.gateway.out.mongo;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.CreateAccountGateway;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import br.com.cezarcruz.javabank.gateway.out.mongo.entity.AccountEntity;
import br.com.cezarcruz.javabank.gateway.out.mongo.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Primary
@Component
@RequiredArgsConstructor
public class AccountMongoGateway implements CreateAccountGateway, GetAccountGateway {

    private final AccountMongoRepository accountMongoRepository;
    private final AccountEntityMapper accountEntityMapper;

    @Override
    public Account create(final Account account) {
        final AccountEntity accountEntity = accountEntityMapper.from(account);
        final AccountEntity savedAccount = accountMongoRepository.save(accountEntity);
        return accountEntityMapper.to(savedAccount);
    }

    @Override
    public Optional<Account> getBy(final String internalId) {
        return accountMongoRepository.findById(internalId)
                .map(accountEntityMapper::to);
    }

    @Override
    public List<Account> getAll() {
        return accountMongoRepository.findAll()
                .stream()
                .map(accountEntityMapper::to)
                .toList();
    }
}
