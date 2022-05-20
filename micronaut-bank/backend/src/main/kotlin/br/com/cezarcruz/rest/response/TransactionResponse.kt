package br.com.cezarcruz.rest.response

import br.com.cezarcruz.core.domain.Amount
import java.time.LocalDateTime

data class TransactionResponse(
    val internalId: String,
    val account: String,
    val value: Amount,
    val operationType: String,
    val time: LocalDateTime,
)