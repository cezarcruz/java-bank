package br.com.cezarcruz.javabank.gateway.in.rest.validators;

import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreateAccountValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return CreateAccountRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "document", "field.required");
    }

}
