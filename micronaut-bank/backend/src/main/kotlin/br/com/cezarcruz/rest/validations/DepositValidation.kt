package br.com.cezarcruz.rest.validations

import br.com.cezarcruz.rest.request.DepositRequest
import br.com.fluentvalidator.AbstractValidator
import br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan
import jakarta.inject.Singleton
import java.math.BigDecimal

@Singleton
class DepositValidation : AbstractValidator<DepositRequest>() {

    override fun rules() {
        ruleFor(DepositRequest::value)
            .must(greaterThan(BigDecimal.ZERO))
            .withMessage("value must be greater than zero")
            .withFieldName("value")
            .critical()
    }
}