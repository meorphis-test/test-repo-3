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
import com.configure_me_meorphis_test_6.api.models.CardUpdateParams
import com.configure_me_meorphis_test_6.api.models.CardUpdateParams.CardUpdateBody

class CardUpdateParamsTest {

    @Test
    fun createCardUpdateParams() {
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
    }

    @Test
    fun getBody() {
      val params = CardUpdateParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .authRuleToken("string")
          .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
          .memo("New Card")
          .pin("string")
          .spendLimit(123L)
          .spendLimitDuration(CardUpdateParams.SpendLimitDuration.ANNUALLY)
          .state(CardUpdateParams.State.CLOSED)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.authRuleToken()).isEqualTo("string")
      assertThat(body.digitalCardArtToken()).isEqualTo("00000000-0000-0000-1000-000000000000")
      assertThat(body.memo()).isEqualTo("New Card")
      assertThat(body.pin()).isEqualTo("string")
      assertThat(body.spendLimit()).isEqualTo(123L)
      assertThat(body.spendLimitDuration()).isEqualTo(CardUpdateParams.SpendLimitDuration.ANNUALLY)
      assertThat(body.state()).isEqualTo(CardUpdateParams.State.CLOSED)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = CardUpdateParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = CardUpdateParams.builder()
          .cardToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "cardToken"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
