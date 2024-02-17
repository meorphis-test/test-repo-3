// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import com.configure_me_meorphis_test_6.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardProvisionPostProvisionParamsTest {

    @Test
    fun createCardProvisionPostProvisionParams() {
        CardProvisionPostProvisionParams.builder()
            .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .certificate("U3RhaW5sZXNzIHJvY2tz")
            .digitalWallet(CardProvisionPostProvisionParams.DigitalWallet.APPLE_PAY)
            .nonce("U3RhaW5sZXNzIHJvY2tz")
            .nonceSignature("U3RhaW5sZXNzIHJvY2tz")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            CardProvisionPostProvisionParams.builder()
                .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .certificate("U3RhaW5sZXNzIHJvY2tz")
                .digitalWallet(CardProvisionPostProvisionParams.DigitalWallet.APPLE_PAY)
                .nonce("U3RhaW5sZXNzIHJvY2tz")
                .nonceSignature("U3RhaW5sZXNzIHJvY2tz")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.certificate()).isEqualTo("U3RhaW5sZXNzIHJvY2tz")
        assertThat(body.digitalWallet())
            .isEqualTo(CardProvisionPostProvisionParams.DigitalWallet.APPLE_PAY)
        assertThat(body.nonce()).isEqualTo("U3RhaW5sZXNzIHJvY2tz")
        assertThat(body.nonceSignature()).isEqualTo("U3RhaW5sZXNzIHJvY2tz")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CardProvisionPostProvisionParams.builder()
                .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params =
            CardProvisionPostProvisionParams.builder()
                .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(params).isNotNull
        // path param "cardToken"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
