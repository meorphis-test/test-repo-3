// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking.cards

import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenParams
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenResponse
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler

class FinancialTransactionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : FinancialTransactionService {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val getFinancialTransactionByTokenHandler:
        Handler<CardFinancialTransactionGetFinancialTransactionByTokenResponse> =
        jsonHandler<CardFinancialTransactionGetFinancialTransactionByTokenResponse>(
                clientOptions.jsonMapper
            )
            .withErrorHandler(errorHandler)

    /** Get the card financial transaction for the provided token. */
    override fun getFinancialTransactionByToken(
        params: CardFinancialTransactionGetFinancialTransactionByTokenParams,
        requestOptions: RequestOptions
    ): CardFinancialTransactionGetFinancialTransactionByTokenResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "cards",
                    params.getPathParam(0),
                    "financial_transactions",
                    params.getPathParam(1)
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { getFinancialTransactionByTokenHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
