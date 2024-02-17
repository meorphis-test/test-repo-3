// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.async.cards

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
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenParams
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenResponse
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

class FinancialTransactionServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : FinancialTransactionServiceAsync {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val getFinancialTransactionByTokenHandler: Handler<CardFinancialTransactionGetFinancialTransactionByTokenResponse> =
    jsonHandler<CardFinancialTransactionGetFinancialTransactionByTokenResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Get the card financial transaction for the provided token. */
    override fun getFinancialTransactionByToken(params: CardFinancialTransactionGetFinancialTransactionByTokenParams, requestOptions: RequestOptions): CompletableFuture<CardFinancialTransactionGetFinancialTransactionByTokenResponse> {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("cards", params.getPathParam(0), "financial_transactions", params.getPathParam(1))
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .thenApply { response -> 
          response.use {
              getFinancialTransactionByTokenHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
