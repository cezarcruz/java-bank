package br.com.cezarcruz.gateway.transaction

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.TransactionHistory

interface GetTransactions {

    fun getBy(account: Account): List<TransactionHistory>

}