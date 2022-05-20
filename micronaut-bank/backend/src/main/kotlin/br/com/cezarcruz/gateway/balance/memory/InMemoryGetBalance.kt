package br.com.cezarcruz.gateway.balance.memory

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.GetBalance
import br.com.cezarcruz.gateway.balance.memory.repository.BalanceRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class InMemoryGetBalance(
    @Inject private val balanceRepository: BalanceRepository,
) : GetBalance {

    override fun get(account: Account): AccountBalance {
        val balanceEntity = balanceRepository.get(account)

        return AccountBalance(
            account = account,
            balance = balanceEntity.balance,
        )
    }

}