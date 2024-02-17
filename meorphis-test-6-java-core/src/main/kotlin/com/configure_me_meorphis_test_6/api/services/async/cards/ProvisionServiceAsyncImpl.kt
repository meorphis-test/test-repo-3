// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.async.cards

import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionParams
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionResponse
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.json
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ProvisionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ProvisionServiceAsync {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val postProvisionHandler: Handler<CardProvisionPostProvisionResponse> =
        jsonHandler<CardProvisionPostProvisionResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Allow your cardholders to directly add payment cards to the device's digital wallet (e.g.
     * Apple Pay) with one touch from your app.
     *
     * This requires some additional setup and configuration. Please
     * [Contact Us](https://acme.com/contact) or your Customer Success representative for more
     * information.
     */
    override fun postProvision(
        params: CardProvisionPostProvisionParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CardProvisionPostProvisionResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("cards", params.getPathParam(0), "provision")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { postProvisionHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
