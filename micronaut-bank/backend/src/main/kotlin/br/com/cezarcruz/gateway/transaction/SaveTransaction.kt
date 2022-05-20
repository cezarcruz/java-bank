package br.com.cezarcruz.gateway.transaction

import br.com.cezarcruz.core.domain.TransactionHistory

interface SaveTransaction {
    fun save(transaction: TransactionHistory)
}