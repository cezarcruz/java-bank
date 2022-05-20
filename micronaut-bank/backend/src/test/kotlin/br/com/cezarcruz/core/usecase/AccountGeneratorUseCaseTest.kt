package br.com.cezarcruz.core.usecase

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldNotBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class AccountGeneratorUseCaseTest(
    @Inject private val accountGeneratorUseCase: AccountGeneratorUseCase,
) : StringSpec({

    "should generate an account" {
        val generatedAccount = accountGeneratorUseCase.generate(100)

        generatedAccount shouldNotBe null
        generatedAccount shouldBeInRange IntRange(10_000, 99_999)

    }

})
