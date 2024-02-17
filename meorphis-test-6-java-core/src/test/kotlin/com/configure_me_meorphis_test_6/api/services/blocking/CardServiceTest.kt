// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking

import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CardServiceTest {

    @Test
    fun callCreate() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardService = client.cards()
        val cardCreateResponse =
            cardService.create(
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
            )
        println(cardCreateResponse)
        cardCreateResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardService = client.cards()
        val cardRetrieveResponse =
            cardService.retrieve(
                CardRetrieveParams.builder()
                    .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(cardRetrieveResponse)
        cardRetrieveResponse.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardService = client.cards()
        val cardUpdateResponse =
            cardService.update(
                CardUpdateParams.builder()
                    .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .authRuleToken("string")
                    .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
                    .memo("New Card")
                    .pin("string")
                    .spendLimit(123L)
                    .spendLimitDuration(CardUpdateParams.SpendLimitDuration.ANNUALLY)
                    .state(CardUpdateParams.State.CLOSED)
                    .build()
            )
        println(cardUpdateResponse)
        cardUpdateResponse.validate()
    }
}
