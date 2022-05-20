package br.com.cezarcruz.core.domain

data class Transfer(
    val origin: Account,
    val destiny: Account,
    val value: Amount,
)