// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking.cards

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.MeorphisTest6Client
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.core.JsonNull
import com.configure_me_meorphis_test_6.api.core.JsonString
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.http.BinaryResponseContent
import com.configure_me_meorphis_test_6.api.services.blocking.cards.FinancialTransactionService
import com.configure_me_meorphis_test_6.api.models.*

@ExtendWith(TestServerExtension::class)
class FinancialTransactionServiceTest {

    @Test
    fun callGetFinancialTransactionByToken() {
      val client = MeorphisTest6OkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val financialTransactionService = client.cards().financialTransactions()
      val cardFinancialTransactionGetFinancialTransactionByTokenResponse = financialTransactionService.getFinancialTransactionByToken(CardFinancialTransactionGetFinancialTransactionByTokenParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .financialTransactionToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(cardFinancialTransactionGetFinancialTransactionByTokenResponse)
      cardFinancialTransactionGetFinancialTransactionByTokenResponse.validate()
    }
}
