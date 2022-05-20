package br.com.cezarcruz.gateway.account

import br.com.cezarcruz.core.domain.Account

interface GetAccount {

    fun get(account: Account): Account

}