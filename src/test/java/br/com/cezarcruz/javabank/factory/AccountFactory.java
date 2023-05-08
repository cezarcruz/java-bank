package br.com.cezarcruz.javabank.factory;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import org.instancio.Instancio;

import static org.instancio.Select.field;

public class AccountFactory {

    public static Account generatePendingAccount() {
        return Instancio.of(Account.class)
            .set(field(Account::status), AccountStatus.PENDING)
            .create();
    }

    public static Account generateActiveAccount() {
        return Instancio.of(Account.class)
            .set(field(Account::status), AccountStatus.ACTIVE)
            .create();
    }

}
