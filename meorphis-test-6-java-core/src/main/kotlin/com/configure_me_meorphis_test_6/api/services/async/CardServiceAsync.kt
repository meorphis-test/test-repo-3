// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.async

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.CardCreateParams
import com.configure_me_meorphis_test_6.api.models.CardCreateResponse
import com.configure_me_meorphis_test_6.api.models.CardRetrieveParams
import com.configure_me_meorphis_test_6.api.models.CardRetrieveResponse
import com.configure_me_meorphis_test_6.api.models.CardUpdateParams
import com.configure_me_meorphis_test_6.api.models.CardUpdateResponse
import com.configure_me_meorphis_test_6.api.services.async.cards.FinancialTransactionServiceAsync
import com.configure_me_meorphis_test_6.api.services.async.cards.ProvisionServiceAsync
import java.util.concurrent.CompletableFuture

interface CardServiceAsync {

    fun financialTransactions(): FinancialTransactionServiceAsync

    fun provisions(): ProvisionServiceAsync

    /**
     * Create a new virtual or physical card. Parameters `pin`, `shipping_address`, and `product_id`
     * only apply to physical cards.
     */
    @JvmOverloads
    fun create(
        params: CardCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CardCreateResponse>

    /** Get card configuration such as spend limit and state. */
    @JvmOverloads
    fun retrieve(
        params: CardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CardRetrieveResponse>

    /**
     * Update the specified properties of the card. Unsupplied properties will remain unchanged.
     * `pin` parameter only applies to physical cards.
     *
     * _Note: setting a card to a `CLOSED` state is a final action that cannot be undone._
     */
    @JvmOverloads
    fun update(
        params: CardUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CardUpdateResponse>
}
