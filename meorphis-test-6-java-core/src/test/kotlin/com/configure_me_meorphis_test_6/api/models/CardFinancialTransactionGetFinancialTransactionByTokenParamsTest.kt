// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import com.configure_me_meorphis_test_6.api.core.JsonNull
import com.configure_me_meorphis_test_6.api.core.JsonString
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.models.*
import com.configure_me_meorphis_test_6.api.models.CardFinancialTransactionGetFinancialTransactionByTokenParams

class CardFinancialTransactionGetFinancialTransactionByTokenParamsTest {

    @Test
    fun createCardFinancialTransactionGetFinancialTransactionByTokenParams() {
      CardFinancialTransactionGetFinancialTransactionByTokenParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .financialTransactionToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = CardFinancialTransactionGetFinancialTransactionByTokenParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .financialTransactionToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "cardToken"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // path param "financialTransactionToken"
      assertThat(params.getPathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
