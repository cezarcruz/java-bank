package br.com.cezarcruz.rest.weberrors.ex

import br.com.fluentvalidator.context.ValidationResult
import br.com.fluentvalidator.exception.ValidationException

class ValidateException(validationResult: ValidationResult?) : ValidationException(validationResult) {

}