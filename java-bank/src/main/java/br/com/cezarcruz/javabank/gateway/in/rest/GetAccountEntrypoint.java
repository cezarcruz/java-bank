package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.GetAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetAccountEntrypoint {

    private final GetAccountUseCase getAccountUseCase;

    public Optional<Account> getBy(final String internalId) {
        return getAccountUseCase.getBy(internalId);
    }

}

