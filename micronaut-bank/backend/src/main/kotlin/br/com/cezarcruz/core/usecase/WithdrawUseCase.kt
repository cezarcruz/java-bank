package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.SaveBalance
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class WithdrawUseCase(
    @Inject private val getAccountBalanceUseCase: GetAccountBalanceUseCase,
    @Inject private val saveBalance: SaveBalance,
    @Inject private val generateTransactionHistoryUseCase: GenerateTransactionHistoryUseCase,
) {

    fun withdraw(accountBalance: AccountBalance): AccountBalance {
        val actualBalance = getAccountBalanceUseCase.get(accountBalance.account)

        val newAccountBalance =
            actualBalance.copy(balance = actualBalance.balance.minus(accountBalance.balance))

        val updatedBalance = saveBalance.update(newAccountBalance)

        generateTransactionHistoryUseCase.generateOut(updatedBalance.account, accountBalance.balance)

        return updatedBalance

    }

}