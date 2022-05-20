package br.com.cezarcruz.gateway.account.memory

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.gateway.account.SaveAccount
import br.com.cezarcruz.gateway.account.memory.repository.AccountRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class InMemorySaveAccount(
    @Inject private val repository: AccountRepository,
) : SaveAccount {
    override fun save(account: Account): Account = repository.add(account)
}