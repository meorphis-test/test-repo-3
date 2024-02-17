// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.async

import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusParams
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusResponse
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class StatusServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : StatusServiceAsync {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val getStatusHandler: Handler<StatusGetStatusResponse> =
        jsonHandler<StatusGetStatusResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** API status check */
    override fun getStatus(
        params: StatusGetStatusParams,
        requestOptions: RequestOptions
    ): CompletableFuture<StatusGetStatusResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("status")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { getStatusHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
