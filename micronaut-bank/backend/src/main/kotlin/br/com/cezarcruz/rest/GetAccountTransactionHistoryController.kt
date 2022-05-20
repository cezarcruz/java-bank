package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.usecase.GetTransactionsUseCase
import br.com.cezarcruz.rest.response.TransactionResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/account")
class GetAccountTransactionHistoryController(
    @Inject private val getTransactions: GetTransactionsUseCase,
) {

    @Get("/{account}/agency/{agency}/transactions")
    fun get(account: Int, agency: Int): List<TransactionResponse> {
        val accountDomain = Account(
            account = account,
            agency = agency,
        )

        return getTransactions.getBy(accountDomain)
            .map {
                TransactionResponse(
                    it.internalId.toString(),
                    it.account.toString(),
                    it.value,
                    it.operation.name,
                    it.time, //TODO: :(
                )
            }
    }

}