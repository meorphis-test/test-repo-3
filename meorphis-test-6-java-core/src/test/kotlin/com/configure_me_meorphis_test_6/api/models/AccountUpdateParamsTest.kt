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
import com.configure_me_meorphis_test_6.api.models.AccountUpdateParams
import com.configure_me_meorphis_test_6.api.models.AccountUpdateParams.AccountUpdateBody

class AccountUpdateParamsTest {

    @Test
    fun createAccountUpdateParams() {
      AccountUpdateParams.builder()
          .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .dailySpendLimit(123L)
          .lifetimeSpendLimit(123L)
          .monthlySpendLimit(123L)
          .state(AccountUpdateParams.State.ACTIVE)
          .verificationAddress(AccountUpdateParams.VerificationAddress.builder()
              .address1("string")
              .address2("string")
              .city("string")
              .country("string")
              .postalCode("string")
              .state("string")
              .build())
          .build()
    }

    @Test
    fun getBody() {
      val params = AccountUpdateParams.builder()
          .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .dailySpendLimit(123L)
          .lifetimeSpendLimit(123L)
          .monthlySpendLimit(123L)
          .state(AccountUpdateParams.State.ACTIVE)
          .verificationAddress(AccountUpdateParams.VerificationAddress.builder()
              .address1("string")
              .address2("string")
              .city("string")
              .country("string")
              .postalCode("string")
              .state("string")
              .build())
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.dailySpendLimit()).isEqualTo(123L)
      assertThat(body.lifetimeSpendLimit()).isEqualTo(123L)
      assertThat(body.monthlySpendLimit()).isEqualTo(123L)
      assertThat(body.state()).isEqualTo(AccountUpdateParams.State.ACTIVE)
      assertThat(body.verificationAddress()).isEqualTo(AccountUpdateParams.VerificationAddress.builder()
          .address1("string")
          .address2("string")
          .city("string")
          .country("string")
          .postalCode("string")
          .state("string")
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = AccountUpdateParams.builder()
          .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = AccountUpdateParams.builder()
          .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "accountToken"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
