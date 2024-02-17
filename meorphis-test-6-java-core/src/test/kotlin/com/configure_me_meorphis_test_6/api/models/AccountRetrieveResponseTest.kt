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
import com.configure_me_meorphis_test_6.api.models.AccountRetrieveResponse

class AccountRetrieveResponseTest {

    @Test
    fun createAccountRetrieveResponse() {
      val accountRetrieveResponse = AccountRetrieveResponse.builder()
          .token("b68b7424-aa69-4cbc-a946-30d90181b621")
          .spendLimit(AccountRetrieveResponse.SpendLimit.builder()
              .daily(123L)
              .lifetime(123L)
              .monthly(123L)
              .build())
          .state(AccountRetrieveResponse.State.ACTIVE)
          .accountHolder(AccountRetrieveResponse.AccountHolder.builder()
              .token("95e5f1b7-cfd5-4520-aa3c-2451bab8608d")
              .businessAccountToken("e87db14a-4abf-4901-adad-5d5c9f46aff2")
              .email("jack@acme.com")
              .phoneNumber("+12124007676")
              .build())
          .authRuleTokens(listOf("string"))
          .verificationAddress(AccountRetrieveResponse.VerificationAddress.builder()
              .address1("124 Old Forest Way")
              .city("Seattle")
              .country("USA")
              .postalCode("98109")
              .state("WA")
              .address2("Apt 21")
              .build())
          .build()
      assertThat(accountRetrieveResponse).isNotNull
      assertThat(accountRetrieveResponse.token()).isEqualTo("b68b7424-aa69-4cbc-a946-30d90181b621")
      assertThat(accountRetrieveResponse.spendLimit()).isEqualTo(AccountRetrieveResponse.SpendLimit.builder()
          .daily(123L)
          .lifetime(123L)
          .monthly(123L)
          .build())
      assertThat(accountRetrieveResponse.state()).isEqualTo(AccountRetrieveResponse.State.ACTIVE)
      assertThat(accountRetrieveResponse.accountHolder()).contains(AccountRetrieveResponse.AccountHolder.builder()
          .token("95e5f1b7-cfd5-4520-aa3c-2451bab8608d")
          .businessAccountToken("e87db14a-4abf-4901-adad-5d5c9f46aff2")
          .email("jack@acme.com")
          .phoneNumber("+12124007676")
          .build())
      assertThat(accountRetrieveResponse.authRuleTokens().get()).containsExactly("string")
      assertThat(accountRetrieveResponse.verificationAddress()).contains(AccountRetrieveResponse.VerificationAddress.builder()
          .address1("124 Old Forest Way")
          .city("Seattle")
          .country("USA")
          .postalCode("98109")
          .state("WA")
          .address2("Apt 21")
          .build())
    }
}
