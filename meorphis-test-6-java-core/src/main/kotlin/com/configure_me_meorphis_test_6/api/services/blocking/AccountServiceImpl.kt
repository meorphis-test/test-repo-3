// File generated from our OpenAPI spec by Stainless.

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
import com.configure_me_meorphis_test_6.api.services.blocking.accounts.CreditConfigurationService
import com.configure_me_meorphis_test_6.api.services.blocking.accounts.CreditConfigurationServiceImpl

class AccountServiceImpl constructor(private val clientOptions: ClientOptions, ) : AccountService {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val creditConfigurations: CreditConfigurationService by lazy { CreditConfigurationServiceImpl(clientOptions) }

    override fun creditConfigurations(): CreditConfigurationService = creditConfigurations

    private val retrieveHandler: Handler<AccountRetrieveResponse> =
    jsonHandler<AccountRetrieveResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Get account configuration such as spend limits. */
    override fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions): AccountRetrieveResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("accounts", params.getPathParam(0))
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              retrieveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val updateHandler: Handler<AccountUpdateResponse> =
    jsonHandler<AccountUpdateResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Update account configuration such as spend limits and verification address. Can
     * only be run on accounts that are part of the program managed by this API key.
     *
     * Accounts that are in the `PAUSED` state will not be able to transact or create
     * new cards.
     */
    override fun update(params: AccountUpdateParams, requestOptions: RequestOptions): AccountUpdateResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("accounts", params.getPathParam(0))
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              updateHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
