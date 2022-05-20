package br.com.cezarcruz.gateway.balance.memory

import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.SaveBalance
import br.com.cezarcruz.gateway.balance.memory.repository.BalanceRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class InMemorySaveBalance(
    @Inject private val balanceRepository: BalanceRepository,
) : SaveBalance {
    override fun save(accountBalance: AccountBalance): AccountBalance {
        balanceRepository.add(accountBalance)
        return accountBalance
    }

    override fun update(accountBalance: AccountBalance): AccountBalance {
        balanceRepository.update(accountBalance)
        return accountBalance;
    }
}