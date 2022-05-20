package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Transfer
import br.com.cezarcruz.gateway.balance.SaveBalance
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class OnlineTransferUseCase(
    @Inject private val getAccountBalanceUseCase: GetAccountBalanceUseCase,
    @Inject private val saveBalance: SaveBalance,
    @Inject private val generateTransactionHistoryUseCase: GenerateTransactionHistoryUseCase,
) {

    fun doTransfer(transfer: Transfer) {
        val origin = getAccountBalanceUseCase.get(transfer.origin)
        val destination = getAccountBalanceUseCase.get(transfer.destiny)

        val destinationNewBalance = destination.copy(balance = destination.balance.plus(transfer.value))
        val originNewBalance = origin.copy(balance = origin.balance.minus(transfer.value))

        saveBalance.update(originNewBalance)
        saveBalance.update(destinationNewBalance)

        generateTransactionHistoryUseCase.generateTransferOut(originNewBalance.account, transfer.value)
        generateTransactionHistoryUseCase.generateTransferIn(destinationNewBalance.account, transfer.value)

    }

}