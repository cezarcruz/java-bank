package br.com.cezarcruz.gateway.account.memory.repository

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.gateway.account.memory.entity.AccountEntity
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class AccountRepository {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    private val accounts: MutableList<AccountEntity> = mutableListOf()

    fun add(account: Account): Account {

        val accountEntity = AccountEntity(
            account = account.account,
            agency = account.agency,
        )

        accounts.add(accountEntity)

        log.info("saved account {} in memory", accountEntity)

        return account.copy(internalId = accountEntity.internalId)
    }

    fun get(account: Account): Account {
        //TODO: throwing ex when account doesn't exists
        val accountEntity = accounts.first { it.account == account.account && it.agency == account.agency }
        return account.copy(internalId = accountEntity.internalId)
    }

}