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
import com.configure_me_meorphis_test_6.api.models.CardUpdateResponse

class CardUpdateResponseTest {

    @Test
    fun createCardUpdateResponse() {
      val cardUpdateResponse = CardUpdateResponse.builder()
          .token("7ef7d65c-9023-4da3-b113-3b8583fd7951")
          .created(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
          .funding(CardUpdateResponse.Funding.builder()
              .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
              .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .lastFour("xxxx")
              .state(CardUpdateResponse.Funding.State.ENABLED)
              .type(CardUpdateResponse.Funding.Type.DEPOSITORY_CHECKING)
              .accountName("string")
              .nickname("x")
              .build())
          .lastFour("xxxx")
          .spendLimit(123L)
          .spendLimitDuration(CardUpdateResponse.SpendLimitDuration.ANNUALLY)
          .state(CardUpdateResponse.State.CLOSED)
          .type(CardUpdateResponse.Type.VIRTUAL)
          .authRuleTokens(listOf("string"))
          .cvv("776")
          .digitalCardArtToken("00000000-0000-0000-1000-000000000000")
          .expMonth("06")
          .expYear("2027")
          .hostname("string")
          .memo("New Card")
          .pan("4111111289144142")
          .build()
      assertThat(cardUpdateResponse).isNotNull
      assertThat(cardUpdateResponse.token()).isEqualTo("7ef7d65c-9023-4da3-b113-3b8583fd7951")
      assertThat(cardUpdateResponse.created()).isEqualTo(OffsetDateTime.parse("2021-06-28T22:53:15Z"))
      assertThat(cardUpdateResponse.funding()).isEqualTo(CardUpdateResponse.Funding.builder()
          .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .lastFour("xxxx")
          .state(CardUpdateResponse.Funding.State.ENABLED)
          .type(CardUpdateResponse.Funding.Type.DEPOSITORY_CHECKING)
          .accountName("string")
          .nickname("x")
          .build())
      assertThat(cardUpdateResponse.lastFour()).isEqualTo("xxxx")
      assertThat(cardUpdateResponse.spendLimit()).isEqualTo(123L)
      assertThat(cardUpdateResponse.spendLimitDuration()).isEqualTo(CardUpdateResponse.SpendLimitDuration.ANNUALLY)
      assertThat(cardUpdateResponse.state()).isEqualTo(CardUpdateResponse.State.CLOSED)
      assertThat(cardUpdateResponse.type()).isEqualTo(CardUpdateResponse.Type.VIRTUAL)
      assertThat(cardUpdateResponse.authRuleTokens().get()).containsExactly("string")
      assertThat(cardUpdateResponse.cvv()).contains("776")
      assertThat(cardUpdateResponse.digitalCardArtToken()).contains("00000000-0000-0000-1000-000000000000")
      assertThat(cardUpdateResponse.expMonth()).contains("06")
      assertThat(cardUpdateResponse.expYear()).contains("2027")
      assertThat(cardUpdateResponse.hostname()).contains("string")
      assertThat(cardUpdateResponse.memo()).contains("New Card")
      assertThat(cardUpdateResponse.pan()).contains("4111111289144142")
    }
}
