package br.com.cezarcruz.gateway.balance.memory.repository

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.gateway.balance.memory.entity.BalanceEntity
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class BalanceRepository {

    //TODO: should i use this.javaClass or static reference?
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val balances: MutableList<BalanceEntity> = mutableListOf()

    fun add(accountBalance: AccountBalance) {

        //TODO: this scenario can't be true, how to deal with?
        accountBalance.account.internalId?.let {

            val balanceEntity = BalanceEntity(
                account = accountBalance.account.internalId,
                balance = accountBalance.balance,
            )

            balances.add(balanceEntity)

            log.info("saved balance {}", balanceEntity)
        }

    }

    fun get(account: Account): BalanceEntity {
        //TODO: should I handle NoSuchElementException?
        return balances.first { it.account == account.internalId }
    }

    fun update(accountBalance: AccountBalance) {
        balances
            .find { it.account == accountBalance.account.internalId }
            ?.balance = accountBalance.balance
    }

}