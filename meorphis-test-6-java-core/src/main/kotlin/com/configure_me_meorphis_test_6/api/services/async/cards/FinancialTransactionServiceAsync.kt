// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.async.cards

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenParams
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenResponse
import java.util.concurrent.CompletableFuture

interface FinancialTransactionServiceAsync {

    /** Get the card financial transaction for the provided token. */
    @JvmOverloads
    fun getFinancialTransactionByToken(
        params: CardFinancialTransactionGetFinancialTransactionByTokenParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CardFinancialTransactionGetFinancialTransactionByTokenResponse>
}
