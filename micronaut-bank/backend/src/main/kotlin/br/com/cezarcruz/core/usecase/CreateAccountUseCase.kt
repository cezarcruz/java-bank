package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.gateway.account.SaveAccount
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class CreateAccountUseCase (
    @Inject private val accountGeneratorUseCase: AccountGeneratorUseCase,
    @Inject private val createInitialAccountBalanceUseCase: CreateInitialAccountBalanceUseCase,
    @Inject private val saveAccount: SaveAccount,
)  {

    fun create(agency: Int): Account {

        val account = Account(
            account = accountGeneratorUseCase.generate(agency),
            agency = agency,
        )

        val savedAccount = saveAccount.save(account)
        createInitialAccountBalanceUseCase.create(savedAccount)

        return account
    }

}