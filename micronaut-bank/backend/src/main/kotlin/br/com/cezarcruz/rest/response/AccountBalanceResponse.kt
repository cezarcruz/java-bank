package br.com.cezarcruz.rest.response

import br.com.cezarcruz.core.domain.Amount

data class AccountBalanceResponse(
    val accountResponse: AccountResponse,
    val balance: Amount,
)