package br.com.cezarcruz.core.usecase

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.SaveBalance
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class CreateInitialAccountBalanceUseCase(
    @Inject private val saveBalance: SaveBalance,
) {

    private val log: Logger =
        LoggerFactory.getLogger(CreateInitialAccountBalanceUseCase::class.java)

    fun create(account: Account): AccountBalance {
        log.info("creating initial balance for account = {}", account)
        val accountBalance = AccountBalance(account)
        saveBalance.save(accountBalance)
        return accountBalance
    }

}