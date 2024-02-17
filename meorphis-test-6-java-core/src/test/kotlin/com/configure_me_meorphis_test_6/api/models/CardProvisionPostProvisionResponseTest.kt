// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardProvisionPostProvisionResponseTest {

    @Test
    fun createCardProvisionPostProvisionResponse() {
        val cardProvisionPostProvisionResponse =
            CardProvisionPostProvisionResponse.builder().provisioningPayload("string").build()
        assertThat(cardProvisionPostProvisionResponse).isNotNull
        assertThat(cardProvisionPostProvisionResponse.provisioningPayload()).contains("string")
    }
}
