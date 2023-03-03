package br.com.cezarcruz.javabank.factory;

import br.com.cezarcruz.javabank.core.domain.Account;
import org.instancio.Instancio;

public class AccountFactory {

    public static Account generateAccount() {
        return Instancio.of(Account.class).create();
    }

}
