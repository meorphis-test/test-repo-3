// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountUpdateResponseTest {

    @Test
    fun createAccountUpdateResponse() {
        val accountUpdateResponse =
            AccountUpdateResponse.builder()
                .token("b68b7424-aa69-4cbc-a946-30d90181b621")
                .spendLimit(
                    AccountUpdateResponse.SpendLimit.builder()
                        .daily(123L)
                        .lifetime(123L)
                        .monthly(123L)
                        .build()
                )
                .state(AccountUpdateResponse.State.ACTIVE)
                .accountHolder(
                    AccountUpdateResponse.AccountHolder.builder()
                        .token("95e5f1b7-cfd5-4520-aa3c-2451bab8608d")
                        .businessAccountToken("e87db14a-4abf-4901-adad-5d5c9f46aff2")
                        .email("jack@acme.com")
                        .phoneNumber("+12124007676")
                        .build()
                )
                .authRuleTokens(listOf("string"))
                .verificationAddress(
                    AccountUpdateResponse.VerificationAddress.builder()
                        .address1("124 Old Forest Way")
                        .city("Seattle")
                        .country("USA")
                        .postalCode("98109")
                        .state("WA")
                        .address2("Apt 21")
                        .build()
                )
                .build()
        assertThat(accountUpdateResponse).isNotNull
        assertThat(accountUpdateResponse.token()).isEqualTo("b68b7424-aa69-4cbc-a946-30d90181b621")
        assertThat(accountUpdateResponse.spendLimit())
            .isEqualTo(
                AccountUpdateResponse.SpendLimit.builder()
                    .daily(123L)
                    .lifetime(123L)
                    .monthly(123L)
                    .build()
            )
        assertThat(accountUpdateResponse.state()).isEqualTo(AccountUpdateResponse.State.ACTIVE)
        assertThat(accountUpdateResponse.accountHolder())
            .contains(
                AccountUpdateResponse.AccountHolder.builder()
                    .token("95e5f1b7-cfd5-4520-aa3c-2451bab8608d")
                    .businessAccountToken("e87db14a-4abf-4901-adad-5d5c9f46aff2")
                    .email("jack@acme.com")
                    .phoneNumber("+12124007676")
                    .build()
            )
        assertThat(accountUpdateResponse.authRuleTokens().get()).containsExactly("string")
        assertThat(accountUpdateResponse.verificationAddress())
            .contains(
                AccountUpdateResponse.VerificationAddress.builder()
                    .address1("124 Old Forest Way")
                    .city("Seattle")
                    .country("USA")
                    .postalCode("98109")
                    .state("WA")
                    .address2("Apt 21")
                    .build()
            )
    }
}
