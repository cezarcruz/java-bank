package br.com.cezarcruz.core.domain

import java.util.*

data class Account(

    //TODO: how to deal with? in this case, internal id will be generated only when saving in db
    val internalId: UUID? = null,
    val account: Int,
    val agency: Int,
)