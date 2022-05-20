package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.core.usecase.WithdrawUseCase
import br.com.cezarcruz.rest.request.WithdrawRequest
import br.com.cezarcruz.rest.response.AccountBalanceResponse
import br.com.cezarcruz.rest.response.AccountResponse
import br.com.cezarcruz.utils.toAmount
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

@Controller("/account")
class WithdrawController(
    @Inject private val withdrawUseCase: WithdrawUseCase,
) {

    @Put("/{account}/agency/{agency}/withdraw")
    fun withdraw(
        @Body withdrawRequest: WithdrawRequest,
        @PathVariable account: Int,
        @PathVariable agency: Int,
    ): AccountBalanceResponse {

        val accountBalance = AccountBalance(
            Account(
                account = account,
                agency = agency,
            ),
            balance = withdrawRequest.value.toAmount()
        )

        val actualAccountBalance = withdrawUseCase.withdraw(accountBalance)

        return AccountBalanceResponse(
            AccountResponse(
                account = actualAccountBalance.account.account,
                agency = actualAccountBalance.account.agency,
            ),
            balance = actualAccountBalance.balance
        )
    }

}