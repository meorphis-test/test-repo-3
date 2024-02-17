// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.async

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusParams
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusResponse
import java.util.concurrent.CompletableFuture

interface StatusServiceAsync {

    /** API status check */
    @JvmOverloads
    fun getStatus(
        params: StatusGetStatusParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<StatusGetStatusResponse>
}
