package br.com.cezarcruz.rest.request

import java.math.BigDecimal

data class WithdrawRequest(
    val value: BigDecimal,
)