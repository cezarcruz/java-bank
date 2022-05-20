package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Account
import br.com.cezarcruz.core.usecase.CreateAccountUseCase
import br.com.cezarcruz.rest.request.CreateAccountRequest
import br.com.cezarcruz.rest.response.AccountResponse
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

@MicronautTest
class CreateAccountControllerTest(
    private val createAccountUseCase: CreateAccountUseCase,
    @Client("/") private val client: HttpClient,
) : StringSpec({

    "should create an account with rest call" {
        val mock = getMock(createAccountUseCase)

        val account = Account (
            internalId = UUID.randomUUID(),
            account = 100,
            agency = 1200
        )

        every { mock.create(100) } answers {
            account
        }

        forAll(
            row(CreateAccountRequest(100)),
        ) { accountRequest: CreateAccountRequest ->

            val result = withContext(Dispatchers.IO) {
                client.toBlocking()
                    .retrieve(HttpRequest.POST("/account", accountRequest), AccountResponse::class.java)
            }

            result shouldNotBe null
            result.account shouldBe account.account
            result.agency shouldBe account.agency

            verify(exactly = 1) { mock.create(100) }
        }
    }


}) {
    @get:MockBean(CreateAccountUseCase::class)
    val createAccountUseCaseMock: CreateAccountUseCase = mockk()
}
