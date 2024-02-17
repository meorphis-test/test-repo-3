// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.blocking

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.LazyThreadSafetyMode.PUBLICATION
import java.time.LocalDate
import java.time.Duration
import java.time.OffsetDateTime
import java.util.Base64
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.stream.Stream
import com.configure_me_meorphis_test_6.api.core.NoAutoDetect
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6InvalidDataException
import com.configure_me_meorphis_test_6.api.models.CardCreateParams
import com.configure_me_meorphis_test_6.api.models.CardCreateResponse
import com.configure_me_meorphis_test_6.api.models.CardRetrieveParams
import com.configure_me_meorphis_test_6.api.models.CardRetrieveResponse
import com.configure_me_meorphis_test_6.api.models.CardUpdateParams
import com.configure_me_meorphis_test_6.api.models.CardUpdateResponse
import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.core.http.BinaryResponseContent
import com.configure_me_meorphis_test_6.api.core.JsonField
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.services.emptyHandler
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.json
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.stringHandler
import com.configure_me_meorphis_test_6.api.services.binaryHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler
import com.configure_me_meorphis_test_6.api.services.blocking.cards.FinancialTransactionService
import com.configure_me_meorphis_test_6.api.services.blocking.cards.FinancialTransactionServiceImpl
import com.configure_me_meorphis_test_6.api.services.blocking.cards.ProvisionService
import com.configure_me_meorphis_test_6.api.services.blocking.cards.ProvisionServiceImpl

interface CardService {

    fun financialTransactions(): FinancialTransactionService

    fun provisions(): ProvisionService

    /**
     * Create a new virtual or physical card. Parameters `pin`, `shipping_address`, and
     * `product_id` only apply to physical cards.
     */
    @JvmOverloads
    fun create(params: CardCreateParams, requestOptions: RequestOptions = RequestOptions.none()): CardCreateResponse

    /** Get card configuration such as spend limit and state. */
    @JvmOverloads
    fun retrieve(params: CardRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): CardRetrieveResponse

    /**
     * Update the specified properties of the card. Unsupplied properties will remain
     * unchanged. `pin` parameter only applies to physical cards.
     *
     * _Note: setting a card to a `CLOSED` state is a final action that cannot be
     * undone._
     */
    @JvmOverloads
    fun update(params: CardUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): CardUpdateResponse
}
