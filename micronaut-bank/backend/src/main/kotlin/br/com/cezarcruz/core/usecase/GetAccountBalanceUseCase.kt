package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.account.GetAccount
import br.com.cezarcruz.gateway.balance.GetBalance
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class GetAccountBalanceUseCase(
    @Inject private val getAccount: GetAccount,
    @Inject private val getBalance: GetBalance,
) {

    fun get(account: Account): AccountBalance {
        val accountFound = getAccount.get(account)
        return getBalance.get(accountFound)
    }

}