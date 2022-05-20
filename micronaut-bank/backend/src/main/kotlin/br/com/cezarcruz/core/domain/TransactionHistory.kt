package br.com.cezarcruz.core.domain

import java.time.LocalDateTime
import java.util.*

data class TransactionHistory(
    val internalId: UUID? = null,
    val account: UUID,
    val value: Amount,
    val operation: TransactionType,
    val time: LocalDateTime = LocalDateTime.now(),
)