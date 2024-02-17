// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.services.blocking.cards

import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionParams
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionResponse

interface ProvisionService {

    /**
     * Allow your cardholders to directly add payment cards to the device's digital wallet (e.g.
     * Apple Pay) with one touch from your app.
     *
     * This requires some additional setup and configuration. Please
     * [Contact Us](https://acme.com/contact) or your Customer Success representative for more
     * information.
     */
    @JvmOverloads
    fun postProvision(
        params: CardProvisionPostProvisionParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardProvisionPostProvisionResponse
}
