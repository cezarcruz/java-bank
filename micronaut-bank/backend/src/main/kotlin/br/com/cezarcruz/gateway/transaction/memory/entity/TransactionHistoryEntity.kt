package br.com.cezarcruz.gateway.transaction.memory.entity

import br.com.cezarcruz.core.domain.Amount
import br.com.cezarcruz.core.domain.TransactionType
import java.time.LocalDateTime
import java.util.*

class TransactionHistoryEntity(
    val internalId: UUID = UUID.randomUUID(),
    val account: UUID,
    val transactionType: TransactionType, //just to simplify
    val value: Amount,
    val time: LocalDateTime,
)