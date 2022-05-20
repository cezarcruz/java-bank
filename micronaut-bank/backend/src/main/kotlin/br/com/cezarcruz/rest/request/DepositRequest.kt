package br.com.cezarcruz.rest.request

import java.math.BigDecimal

data class DepositRequest(
    val value: BigDecimal,
)
