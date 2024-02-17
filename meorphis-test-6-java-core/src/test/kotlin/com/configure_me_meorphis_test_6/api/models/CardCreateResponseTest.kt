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
import com.configure_me_meorphis_test_6.api.models.CardCreateResponse

class CardCreateResponseTest {

    @Test
    fun createCardCreateResponse() {
      val cardCreateResponse = CardCreateResponse.builder()
          .token("7ef7d65c-9023-4da3-b113-3b8583fd7951")
          .created(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
          .funding(CardCreateResponse.Funding.builder()
              .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
              .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .lastFour("xxxx")
              .state(CardCreateResponse.Funding.State.ENABLED)
              .type(CardCreateResponse.Funding.Type.DEPOSITORY_CHECKING)
              .accountName("string")
              .nickname("x")
              .build())
          .lastFour("xxxx")
          .spendLimit(123L)
          .spendLimitDuration(CardCreateResponse.SpendLimitDuration.ANNUALLY)
          .state(CardCreateResponse.State.CLOSED)
          .type(CardCreateResponse.Type.VIRTUAL)
          .authRuleTokens(listOf("string"))
          .cvv("776")
          .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
          .expMonth("06")
          .expYear("2027")
          .hostname("string")
          .memo("New Card")
          .pan("4111111289144142")
          .build()
      assertThat(cardCreateResponse).isNotNull
      assertThat(cardCreateResponse.token()).isEqualTo("7ef7d65c-9023-4da3-b113-3b8583fd7951")
      assertThat(cardCreateResponse.created()).isEqualTo(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
      assertThat(cardCreateResponse.funding()).isEqualTo(CardCreateResponse.Funding.builder()
          .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .lastFour("xxxx")
          .state(CardCreateResponse.Funding.State.ENABLED)
          .type(CardCreateResponse.Funding.Type.DEPOSITORY_CHECKING)
          .accountName("string")
          .nickname("x")
          .build())
      assertThat(cardCreateResponse.lastFour()).isEqualTo("xxxx")
      assertThat(cardCreateResponse.spendLimit()).isEqualTo(123L)
      assertThat(cardCreateResponse.spendLimitDuration()).isEqualTo(CardCreateResponse.SpendLimitDuration.ANNUALLY)
      assertThat(cardCreateResponse.state()).isEqualTo(CardCreateResponse.State.CLOSED)
      assertThat(cardCreateResponse.type()).isEqualTo(CardCreateResponse.Type.VIRTUAL)
      assertThat(cardCreateResponse.authRuleTokens().get()).containsExactly("string")
      assertThat(cardCreateResponse.cvv()).contains("776")
      assertThat(cardCreateResponse.digitalCardArtToken()).contains("00000000-0000-0000-1000-000000000000")
      assertThat(cardCreateResponse.expMonth()).contains("06")
      assertThat(cardCreateResponse.expYear()).contains("2027")
      assertThat(cardCreateResponse.hostname()).contains("string")
      assertThat(cardCreateResponse.memo()).contains("New Card")
      assertThat(cardCreateResponse.pan()).contains("4111111289144142")
    }
}
