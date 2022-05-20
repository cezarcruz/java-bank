package br.com.cezarcruz.core.usecase

import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.random.Random

@Singleton
class AccountGeneratorUseCase {

    fun generate(agency: Int): Int {
        logger.info("generating account to agency {}", agency)
        return Random.nextInt(10_000, 99_999)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(AccountGeneratorUseCase::class.java)
    }

}