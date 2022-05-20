package br.com.cezarcruz.rest

import br.com.cezarcruz.core.usecase.CreateAccountUseCase
import br.com.cezarcruz.rest.request.CreateAccountRequest
import br.com.cezarcruz.rest.response.AccountResponse
import br.com.cezarcruz.rest.validations.CreateAccountValidation
import br.com.cezarcruz.rest.weberrors.ex.ValidateException
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import jakarta.inject.Inject

@Controller("/account")
class CreateAccountController(
    @Inject private val createAccountUseCase: CreateAccountUseCase,
    @Inject private val createAccountValidation: CreateAccountValidation,
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(accountRequest: CreateAccountRequest): AccountResponse {

        createAccountValidation.validate(accountRequest)
            .isInvalidThrow(ValidateException::class.java)

        val create = createAccountUseCase.create(accountRequest.agency)
        return AccountResponse(create.account, create.agency)
    }
}