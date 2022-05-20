package br.com.cezarcruz.gateway.account.memory

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.gateway.account.GetAccount
import br.com.cezarcruz.gateway.account.memory.repository.AccountRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class InMemoryGetAccount (
    @Inject private val accountRepository: AccountRepository,
) : GetAccount {
    override fun get(account: Account): Account = accountRepository.get(account)
}