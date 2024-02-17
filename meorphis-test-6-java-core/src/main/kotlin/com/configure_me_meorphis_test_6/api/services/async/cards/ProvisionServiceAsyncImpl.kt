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
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionParams
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionResponse
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

class ProvisionServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : ProvisionServiceAsync {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val postProvisionHandler: Handler<CardProvisionPostProvisionResponse> =
    jsonHandler<CardProvisionPostProvisionResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Allow your cardholders to directly add payment cards to the device's digital
     * wallet (e.g. Apple Pay) with one touch from your app.
     *
     * This requires some additional setup and configuration. Please
     * [Contact Us](https://acme.com/contact) or your Customer Success representative
     * for more information.
     */
    override fun postProvision(params: CardProvisionPostProvisionParams, requestOptions: RequestOptions): CompletableFuture<CardProvisionPostProvisionResponse> {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("cards", params.getPathParam(0), "provision")
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .thenApply { response -> 
          response.use {
              postProvisionHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
