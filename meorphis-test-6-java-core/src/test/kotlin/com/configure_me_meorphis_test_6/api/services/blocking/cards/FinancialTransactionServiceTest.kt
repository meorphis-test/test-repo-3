// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking.cards

import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FinancialTransactionServiceTest {

    @Test
    fun callGetFinancialTransactionByToken() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val financialTransactionService = client.cards().financialTransactions()
        val cardFinancialTransactionGetFinancialTransactionByTokenResponse =
            financialTransactionService.getFinancialTransactionByToken(
                CardFinancialTransactionGetFinancialTransactionByTokenParams.builder()
                    .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .financialTransactionToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(cardFinancialTransactionGetFinancialTransactionByTokenResponse)
        cardFinancialTransactionGetFinancialTransactionByTokenResponse.validate()
    }
}
