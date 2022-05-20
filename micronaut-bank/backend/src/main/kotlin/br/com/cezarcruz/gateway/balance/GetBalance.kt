package br.com.cezarcruz.gateway.balance

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance

interface GetBalance {

    fun get(account: Account): AccountBalance

}