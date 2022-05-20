package br.com.cezarcruz.rest.transformation

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.rest.request.AccountRequest

fun AccountRequest.toDomain(): Account {
    return Account(
        agency = this.agency,
        account = this.account,
    )
}