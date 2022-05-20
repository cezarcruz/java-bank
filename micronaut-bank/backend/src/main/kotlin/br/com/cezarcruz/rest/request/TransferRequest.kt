package br.com.cezarcruz.rest.request

import java.math.BigDecimal

data class TransferRequest(
    val origin: AccountRequest,
    val destination: AccountRequest,
    val value: BigDecimal,
)