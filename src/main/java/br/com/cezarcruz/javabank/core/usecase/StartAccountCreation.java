package br.com.cezarcruz.javabank.core.usecase;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.PublishAccountCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartAccountCreation {

    private final PublishAccountCreation publishAccountCreation;

    //pretend this will have some logic in future
    public void create(final Account account) {
        publishAccountCreation.create(account);
    }
}
