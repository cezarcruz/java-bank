package br.com.cezarcruz.gateway.transaction.memory.repository

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.Amount
import br.com.cezarcruz.core.domain.TransactionHistory
import br.com.cezarcruz.core.domain.TransactionType
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@MicronautTest
class TransactionHistoryRepositoryTest(
    @Inject private val transactionHistoryRepository: TransactionHistoryRepository,
) : StringSpec({

    afterTest { (_, _) ->
        transactionHistoryRepository.clear()
    }

    "should save a transaction" {

        val transactionHistory = TransactionHistory(
            internalId = UUID.randomUUID(),
            account = UUID.randomUUID(),
            value = Amount(BigDecimal.TEN),
            operation = TransactionType.DEPOSIT,
            time = LocalDateTime.now(),
        )

        transactionHistoryRepository.save(transactionHistory)

        val account = Account(transactionHistory.account, 12321, 100)
        val transactions = transactionHistoryRepository.getAllBy(account)

        transactions shouldNotBe null
        transactions.size shouldBe 1
        transactions[0].internalId shouldNotBe transactionHistory.internalId
        transactions[0].account shouldBe account.internalId
    }

    "search transaction with account without transaction" {
        val transactionHistory = TransactionHistory(
            internalId = UUID.randomUUID(),
            account = UUID.randomUUID(),
            value = Amount(BigDecimal.TEN),
            operation = TransactionType.DEPOSIT,
            time = LocalDateTime.now(),
        )

        transactionHistoryRepository.save(transactionHistory)

        val account = Account(UUID.randomUUID(), 12321, 100)
        val transactions = transactionHistoryRepository.getAllBy(account)

        transactions shouldBe emptyList()
    }

})
