package br.com.cezarcruz.rest.weberrors

import br.com.cezarcruz.rest.weberrors.ex.ValidateException
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.exceptions.HttpClientException
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Produces
@Singleton
@Requires(classes = [Throwable::class])
class WebExceptionHandler :
    ExceptionHandler<Throwable, HttpResponse<WebExceptionHandler.ErrorResponse>> {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun handle(request: HttpRequest<*>?, exception: Throwable?): HttpResponse<ErrorResponse> {

        request?.let {
            val httpMethod = it.method
            val methodName = it.methodName
            val path = it.path

            logger.error("Received error in [$methodName] on [$path] with method [$httpMethod]: $exception")
        }

        return when (exception) {
            is ValidateException -> handleValidationException(exception)
            is NoSuchElementException -> HttpResponse.notFound(ErrorResponse(404, "Resource not found"))
            is HttpClientException -> HttpResponse.serverError(ErrorResponse(428, "Client could not resolve URI"))
            else -> HttpResponse.status(HttpStatus.I_AM_A_TEAPOT)
        }
    }

    private fun handleValidationException(exception: ValidateException): HttpResponse<ErrorResponse> {
        val fieldsWithErrors =
            exception.validationResult.errors.map { Field(it.field, it.message) }

        val error = ErrorResponse(400, "Invalid Payload", fieldsWithErrors)

        return HttpResponse.badRequest(error)
    }

    data class Field(val name: String, val message: String)
    data class ErrorResponse(val code: Int, val message: String, val fields: List<Field>? = null)
}