package br.com.cezarcruz.core.domain

data class AccountBalance(
    val account: Account,
    val balance: Amount = Amount(),
)