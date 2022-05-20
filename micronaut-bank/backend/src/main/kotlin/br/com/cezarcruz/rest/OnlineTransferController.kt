package br.com.cezarcruz.rest

import br.com.cezarcruz.core.domain.Transfer
import br.com.cezarcruz.core.usecase.OnlineTransferUseCase
import br.com.cezarcruz.rest.request.TransferRequest
import br.com.cezarcruz.rest.transformation.toDomain
import br.com.cezarcruz.utils.toAmount
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

@Controller("/transfer")
class OnlineTransferController(
    @Inject private val transferUseCase: OnlineTransferUseCase,
) {

    @Put
    fun transfer(transfer: TransferRequest) {
        val transferDomain = Transfer(
            origin = transfer.origin.toDomain(),
            destiny = transfer.destination.toDomain(),
            value = transfer.value.toAmount(),
        )
        transferUseCase.doTransfer(transferDomain)
    }

}