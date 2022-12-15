package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.GetAccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetAccountUseCase {

    private final GetAccountGateway getAccountGateway;

    public Optional<Account> getBy(final String internalId) {
        return getAccountGateway.getBy(internalId);
    }

    public Mono<List<Account>> getAll() {
        return getAccountGateway.getAll();
    }

}
