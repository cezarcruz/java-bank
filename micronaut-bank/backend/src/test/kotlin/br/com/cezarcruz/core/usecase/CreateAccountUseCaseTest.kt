package br.com.cezarcruz.core.usecase

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject


@MicronautTest
internal class CreateAccountUseCaseTest(
    @Inject private val createAccountUseCase: CreateAccountUseCase,
) : StringSpec({

    "should create a new account" {
        val account = createAccountUseCase.create(1)

        account shouldNotBe null
        account.account shouldNotBe null
        account.agency shouldBe 1

    }
})