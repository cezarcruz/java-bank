package br.com.cezarcruz.javabank.core.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

class AccountGeneratorUseCaseTest {


    private AccountGeneratorUseCase accountGeneratorUseCase;

    @BeforeEach
    void before() {
        accountGeneratorUseCase = new AccountGeneratorUseCase();
    }

    @Test
    void shouldGenerateNewAccount() {
        final Integer accountNumber = accountGeneratorUseCase.generate("001");

        assertThat(accountNumber, notNullValue());
    }

}