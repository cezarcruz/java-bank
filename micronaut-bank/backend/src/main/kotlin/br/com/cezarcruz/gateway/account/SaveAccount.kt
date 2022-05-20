package br.com.cezarcruz.gateway.account

import br.com.cezarcruz.core.domain.Account

interface SaveAccount {
    fun save(account: Account): Account
}