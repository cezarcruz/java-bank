package br.com.cezarcruz.utils

import br.com.cezarcruz.core.domain.Amount
import java.math.BigDecimal

fun BigDecimal.toAmount(): Amount {
    return Amount(this)
}