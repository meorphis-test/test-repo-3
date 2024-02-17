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
import com.configure_me_meorphis_test_6.api.models.CardRetrieveResponse

class CardRetrieveResponseTest {

    @Test
    fun createCardRetrieveResponse() {
      val cardRetrieveResponse = CardRetrieveResponse.builder()
          .token("7ef7d65c-9023-4da3-b113-3b8583fd7951")
          .created(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
          .funding(CardRetrieveResponse.Funding.builder()
              .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
              .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .lastFour("xxxx")
              .state(CardRetrieveResponse.Funding.State.ENABLED)
              .type(CardRetrieveResponse.Funding.Type.DEPOSITORY_CHECKING)
              .accountName("string")
              .nickname("x")
              .build())
          .lastFour("xxxx")
          .spendLimit(123L)
          .spendLimitDuration(CardRetrieveResponse.SpendLimitDuration.ANNUALLY)
          .state(CardRetrieveResponse.State.CLOSED)
          .type(CardRetrieveResponse.Type.VIRTUAL)
          .authRuleTokens(listOf("string"))
          .cvv("776")
          .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
          .expMonth("06")
          .expYear("2027")
          .hostname("string")
          .memo("New Card")
          .pan("4111111289144142")
          .build()
      assertThat(cardRetrieveResponse).isNotNull
      assertThat(cardRetrieveResponse.token()).isEqualTo("7ef7d65c-9023-4da3-b113-3b8583fd7951")
      assertThat(cardRetrieveResponse.created()).isEqualTo(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
      assertThat(cardRetrieveResponse.funding()).isEqualTo(CardRetrieveResponse.Funding.builder()
          .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .lastFour("xxxx")
          .state(CardRetrieveResponse.Funding.State.ENABLED)
          .type(CardRetrieveResponse.Funding.Type.DEPOSITORY_CHECKING)
          .accountName("string")
          .nickname("x")
          .build())
      assertThat(cardRetrieveResponse.lastFour()).isEqualTo("xxxx")
      assertThat(cardRetrieveResponse.spendLimit()).isEqualTo(123L)
      assertThat(cardRetrieveResponse.spendLimitDuration()).isEqualTo(CardRetrieveResponse.SpendLimitDuration.ANNUALLY)
      assertThat(cardRetrieveResponse.state()).isEqualTo(CardRetrieveResponse.State.CLOSED)
      assertThat(cardRetrieveResponse.type()).isEqualTo(CardRetrieveResponse.Type.VIRTUAL)
      assertThat(cardRetrieveResponse.authRuleTokens().get()).containsExactly("string")
      assertThat(cardRetrieveResponse.cvv()).contains("776")
      assertThat(cardRetrieveResponse.digitalCardArtToken()).contains("00000000-0000-0000-1000-000000000000")
      assertThat(cardRetrieveResponse.expMonth()).contains("06")
      assertThat(cardRetrieveResponse.expYear()).contains("2027")
      assertThat(cardRetrieveResponse.hostname()).contains("string")
      assertThat(cardRetrieveResponse.memo()).contains("New Card")
      assertThat(cardRetrieveResponse.pan()).contains("4111111289144142")
    }
}