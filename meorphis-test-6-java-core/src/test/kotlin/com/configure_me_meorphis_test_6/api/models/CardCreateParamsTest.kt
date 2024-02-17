// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import com.configure_me_meorphis_test_6.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardCreateParamsTest {

    @Test
    fun createCardCreateParams() {
        CardCreateParams.builder()
            .type(CardCreateParams.Type.VIRTUAL)
            .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .cardProgramToken("00000000-0000-0000-1000-000000000000")
            .carrier(CardCreateParams.Carrier.builder().qrCodeUrl("string").build())
            .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
            .expMonth("06")
            .expYear("2027")
            .memo("New Card")
            .pin("string")
            .productId("1")
            .shippingAddress(
                CardCreateParams.ShippingAddress.builder()
                    .address1("5 Broad Street")
                    .city("NEW YORK")
                    .country("USA")
                    .firstName("Michael")
                    .lastName("Bluth")
                    .postalCode("10001-1809")
                    .state("NY")
                    .address2("Unit 25A")
                    .email("johnny@appleseed.com")
                    .line2Text("The Bluth Company")
                    .phoneNumber("+12124007676")
                    .build()
            )
            .shippingMethod(CardCreateParams.ShippingMethod.STANDARD)
            .spendLimit(123L)
            .spendLimitDuration(CardCreateParams.SpendLimitDuration.ANNUALLY)
            .state(CardCreateParams.State.OPEN)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            CardCreateParams.builder()
                .type(CardCreateParams.Type.VIRTUAL)
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .cardProgramToken("00000000-0000-0000-1000-000000000000")
                .carrier(CardCreateParams.Carrier.builder().qrCodeUrl("string").build())
                .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
                .expMonth("06")
                .expYear("2027")
                .memo("New Card")
                .pin("string")
                .productId("1")
                .shippingAddress(
                    CardCreateParams.ShippingAddress.builder()
                        .address1("5 Broad Street")
                        .city("NEW YORK")
                        .country("USA")
                        .firstName("Michael")
                        .lastName("Bluth")
                        .postalCode("10001-1809")
                        .state("NY")
                        .address2("Unit 25A")
                        .email("johnny@appleseed.com")
                        .line2Text("The Bluth Company")
                        .phoneNumber("+12124007676")
                        .build()
                )
                .shippingMethod(CardCreateParams.ShippingMethod.STANDARD)
                .spendLimit(123L)
                .spendLimitDuration(CardCreateParams.SpendLimitDuration.ANNUALLY)
                .state(CardCreateParams.State.OPEN)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.type()).isEqualTo(CardCreateParams.Type.VIRTUAL)
        assertThat(body.accountToken()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.cardProgramToken()).isEqualTo("00000000-0000-0000-1000-000000000000")
        assertThat(body.carrier())
            .isEqualTo(CardCreateParams.Carrier.builder().qrCodeUrl("string").build())
        assertThat(body.digitalCardArtToken()).isEqualTo("00000000-0000-0000-1000-000000000000")
        assertThat(body.expMonth()).isEqualTo("06")
        assertThat(body.expYear()).isEqualTo("2027")
        assertThat(body.memo()).isEqualTo("New Card")
        assertThat(body.pin()).isEqualTo("string")
        assertThat(body.productId()).isEqualTo("1")
        assertThat(body.shippingAddress())
            .isEqualTo(
                CardCreateParams.ShippingAddress.builder()
                    .address1("5 Broad Street")
                    .city("NEW YORK")
                    .country("USA")
                    .firstName("Michael")
                    .lastName("Bluth")
                    .postalCode("10001-1809")
                    .state("NY")
                    .address2("Unit 25A")
                    .email("johnny@appleseed.com")
                    .line2Text("The Bluth Company")
                    .phoneNumber("+12124007676")
                    .build()
            )
        assertThat(body.shippingMethod()).isEqualTo(CardCreateParams.ShippingMethod.STANDARD)
        assertThat(body.spendLimit()).isEqualTo(123L)
        assertThat(body.spendLimitDuration())
            .isEqualTo(CardCreateParams.SpendLimitDuration.ANNUALLY)
        assertThat(body.state()).isEqualTo(CardCreateParams.State.OPEN)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = CardCreateParams.builder().type(CardCreateParams.Type.VIRTUAL).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.type()).isEqualTo(CardCreateParams.Type.VIRTUAL)
    }
}
