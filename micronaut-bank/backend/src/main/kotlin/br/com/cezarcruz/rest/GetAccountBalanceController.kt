package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.usecase.GetAccountBalanceUseCase
import br.com.cezarcruz.rest.response.AccountBalanceResponse
import br.com.cezarcruz.rest.response.AccountResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/account")
class GetAccountBalanceController(
    @Inject private val getAccountBalanceUseCase: GetAccountBalanceUseCase,
) {

    @Get("/{account}/agency/{agency}/balance")
    fun getBalance(account: Int, agency: Int): AccountBalanceResponse {

        val accountDomain = Account(
            account = account,
            agency = agency,
        )

        val accountBalance = getAccountBalanceUseCase.get(accountDomain)

        return AccountBalanceResponse(
            AccountResponse(accountBalance.account.account, accountBalance.account.agency),
            accountBalance.balance,
        )

    }

}