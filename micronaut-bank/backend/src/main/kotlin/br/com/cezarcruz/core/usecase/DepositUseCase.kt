package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.SaveBalance
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Singleton
class DepositUseCase(
    @Inject private val getAccountBalanceUseCase: GetAccountBalanceUseCase,
    @Inject private val saveBalance: SaveBalance,
    @Inject private val generateTransactionHistoryUseCase: GenerateTransactionHistoryUseCase,
) {

    fun deposit(accountBalance: AccountBalance): AccountBalance {
        val actualBalance = getAccountBalanceUseCase.get(accountBalance.account)
        val newBalance = actualBalance
            .copy(balance = actualBalance.balance.plus(accountBalance.balance))

        val updatedAccountBalance = saveBalance.update(newBalance)

        //TODO: using coroutines because I can
        CoroutineScope(Dispatchers.Default).launch {
            generateTransactionHistoryUseCase.generateIn(updatedAccountBalance.account, accountBalance.balance)
        }

        return updatedAccountBalance
    }

}