package br.com.cezarcruz.rest.validations

import br.com.cezarcruz.rest.request.CreateAccountRequest
import br.com.fluentvalidator.AbstractValidator
import br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan
import br.com.fluentvalidator.predicate.ObjectPredicate.nullValue
import jakarta.inject.Singleton
import java.util.function.Predicate.not

@Singleton
class CreateAccountValidation : AbstractValidator<CreateAccountRequest>() {

    override fun rules() {
        ruleFor(CreateAccountRequest::agency)
            .must(not(nullValue()))
                .withMessage("agency cant be empty")
                .withFieldName("agency")
            .must(greaterThan(0))
                .withMessage("agency cant be equals or less than 0")
                .withFieldName("agency")
            .critical()
    }

}