package br.com.cezarcruz.gateway.account.memory.entity

import java.util.*

data class AccountEntity(
    val internalId: UUID = UUID.randomUUID(),
    val account: Int,
    val agency: Int,
)
