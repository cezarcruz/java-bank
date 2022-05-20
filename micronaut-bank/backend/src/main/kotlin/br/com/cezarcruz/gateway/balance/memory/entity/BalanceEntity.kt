package br.com.cezarcruz.gateway.balance.memory.entity

import br.com.cezarcruz.core.domain.Amount
import java.util.*

data class BalanceEntity(
    val internalId: UUID = UUID.randomUUID(),
    val account: UUID,
    var balance: Amount,
)