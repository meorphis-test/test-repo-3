// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking.accounts

import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationListResponse
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationParams
import com.configure_me_meorphis_test_6.api.models.AccountCreditConfigurationPatchAccountCreditConfigurationResponse
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.json
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler

class CreditConfigurationServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CreditConfigurationService {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<AccountCreditConfigurationListResponse> =
        jsonHandler<AccountCreditConfigurationListResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get an Account's credit configuration */
    override fun list(
        params: AccountCreditConfigurationListParams,
        requestOptions: RequestOptions
    ): AccountCreditConfigurationListResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounts", params.getPathParam(0), "credit_configuration")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val patchAccountCreditConfigurationHandler:
        Handler<AccountCreditConfigurationPatchAccountCreditConfigurationResponse> =
        jsonHandler<AccountCreditConfigurationPatchAccountCreditConfigurationResponse>(
                clientOptions.jsonMapper
            )
            .withErrorHandler(errorHandler)

    /** Update a Business Accounts credit configuration */
    override fun patchAccountCreditConfiguration(
        params: AccountCreditConfigurationPatchAccountCreditConfigurationParams,
        requestOptions: RequestOptions
    ): AccountCreditConfigurationPatchAccountCreditConfigurationResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("accounts", params.getPathParam(0), "credit_configuration")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { patchAccountCreditConfigurationHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
