package br.com.cezarcruz.core.domain

import java.math.BigDecimal

@JvmInline
value class Amount(val value: BigDecimal = BigDecimal.ZERO) : Comparable<Amount> {
    //TODO: hummm
    operator fun plus(b: Amount) = Amount(this.value.plus(b.value))
    operator fun minus(b: Amount) = Amount(this.value.minus(b.value))
    override fun compareTo(other: Amount): Int = this.value.compareTo(other.value)

}
