package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.Amount
import br.com.cezarcruz.core.domain.TransactionHistory
import br.com.cezarcruz.core.domain.TransactionType
import br.com.cezarcruz.gateway.transaction.SaveTransaction
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class GenerateTransactionHistoryUseCase(
    @Inject private val saveTransaction: SaveTransaction,
) {

    fun generateIn(account: Account, value: Amount) {
        save(account, value, TransactionType.DEPOSIT)
    }

    fun generateOut(account: Account, value: Amount) {
        save(account, value, TransactionType.WITHDRAW)
    }

    fun generateTransferOut(account: Account, value: Amount) {
        save(account, value, TransactionType.TRANSFER_OUT)
    }

    fun generateTransferIn(account: Account, value: Amount) {
        save(account, value, TransactionType.TRANSFER_IN)
    }

    private fun save(account: Account, value: Amount, operation: TransactionType) {
        account.internalId?.let {
            val transactionHistory = TransactionHistory(
                account = it,
                value = value,
                operation = operation
            )

            saveTransaction.save(transactionHistory)
        }
    }
}