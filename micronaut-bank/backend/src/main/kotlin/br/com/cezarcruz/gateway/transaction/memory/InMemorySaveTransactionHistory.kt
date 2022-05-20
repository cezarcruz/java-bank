package br.com.cezarcruz.gateway.transaction.memory

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.TransactionHistory
import br.com.cezarcruz.gateway.transaction.GetTransactions
import br.com.cezarcruz.gateway.transaction.SaveTransaction
import br.com.cezarcruz.gateway.transaction.memory.repository.TransactionHistoryRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class InMemorySaveTransactionHistory(
    @Inject private val transactionHistoryRepository: TransactionHistoryRepository,
) : SaveTransaction, GetTransactions {

    override fun save(transaction: TransactionHistory) {
        transactionHistoryRepository.save(transaction)
    }

    override fun getBy(account: Account): List<TransactionHistory> {
        return transactionHistoryRepository.getAllBy(account)
    }

}