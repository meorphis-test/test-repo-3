// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.blocking

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusParams
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusResponse

interface StatusService {

    /** API status check */
    @JvmOverloads
    fun getStatus(
        params: StatusGetStatusParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): StatusGetStatusResponse
}
