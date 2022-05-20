package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.domain.AccountBalance
import br.com.cezarcruz.core.usecase.DepositUseCase
import br.com.cezarcruz.rest.request.DepositRequest
import br.com.cezarcruz.rest.response.AccountBalanceResponse
import br.com.cezarcruz.rest.response.AccountResponse
import br.com.cezarcruz.rest.validations.DepositValidation
import br.com.cezarcruz.rest.weberrors.ex.ValidateException
import br.com.cezarcruz.utils.toAmount
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

@Controller("/account")
class DepositController(
    @Inject private val depositUseCase: DepositUseCase,
    @Inject private val depositValidation: DepositValidation,
) {

    @Put("/{account}/agency/{agency}/deposit")
    fun deposit(
        @Body depositRequest: DepositRequest,
        @PathVariable account: Int,
        @PathVariable agency: Int,
    ): AccountBalanceResponse {

        depositValidation.validate(depositRequest)
            .isInvalidThrow(ValidateException::class.java)

        val accountBalance = AccountBalance(
            Account(
                account = account,
                agency = agency
            ),
            balance = depositRequest.value.toAmount()
        )

        val newBalance = depositUseCase.deposit(accountBalance)

        return AccountBalanceResponse(
            AccountResponse(
                account = newBalance.account.account,
                agency = newBalance.account.agency,
            ),
            balance = newBalance.balance
        )

    }

}