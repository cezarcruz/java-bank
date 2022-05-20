package br.com.cezarcruz.gateway.transaction.memory.repository

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.TransactionHistory
import br.com.cezarcruz.gateway.transaction.memory.entity.TransactionHistoryEntity
import jakarta.inject.Singleton

@Singleton
class TransactionHistoryRepository {

    private val history: MutableList<TransactionHistoryEntity> = mutableListOf()

    fun save(transactionHistory: TransactionHistory) {
        val historyEntity = TransactionHistoryEntity(
            account = transactionHistory.account,
            transactionType = transactionHistory.operation,
            value = transactionHistory.value,
            time = transactionHistory.time
        )

        history.add(historyEntity)
    }

    fun getAllBy(account: Account): List<TransactionHistory> {
        return history
            .filter { it.account == account.internalId }
            .map {
                TransactionHistory(
                    it.internalId,
                    it.account,
                    it.value,
                    it.transactionType,
                    it.time,
                )
            }
    }

    fun clear() {
        this.history.clear()
    }
}