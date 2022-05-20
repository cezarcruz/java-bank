package br.com.cezarcruz.gateway.balance

import br.com.cezarcruz.core.domain.AccountBalance

interface SaveBalance {
    fun save(accountBalance: AccountBalance): AccountBalance
    fun update(accountBalance: AccountBalance): AccountBalance
}