package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.TransactionHistory
import br.com.cezarcruz.gateway.account.GetAccount
import br.com.cezarcruz.gateway.transaction.GetTransactions
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class GetTransactionsUseCase(
    @Inject private val getTransactions: GetTransactions,
    @Inject private val getAccount: GetAccount,
) {

    fun getBy(account: Account): List<TransactionHistory> {
        val existentAccount = getAccount.get(account)
        return getTransactions.getBy(existentAccount)
    }

}