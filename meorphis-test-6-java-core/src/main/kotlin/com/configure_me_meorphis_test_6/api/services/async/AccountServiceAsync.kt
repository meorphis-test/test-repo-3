// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.async

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
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveParams
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveResponse
import com.configure_me_meorphis_test_6.api.models.AccountUpdateParams
import com.configure_me_meorphis_test_6.api.models.AccountUpdateResponse
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
import com.configure_me_meorphis_test_6.api.services.async.accounts.CreditConfigurationServiceAsync
import com.configure_me_meorphis_test_6.api.services.async.accounts.CreditConfigurationServiceAsyncImpl

interface AccountServiceAsync {

    fun creditConfigurations(): CreditConfigurationServiceAsync

    /** Get account configuration such as spend limits. */
    @JvmOverloads
    fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<AccountRetrieveResponse>

    /**
     * Update account configuration such as spend limits and verification address. Can
     * only be run on accounts that are part of the program managed by this API key.
     *
     * Accounts that are in the `PAUSED` state will not be able to transact or create
     * new cards.
     */
    @JvmOverloads
    fun update(params: AccountUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<AccountUpdateResponse>
}
