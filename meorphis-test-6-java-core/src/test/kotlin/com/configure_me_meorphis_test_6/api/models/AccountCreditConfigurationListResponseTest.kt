// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountCreditConfigurationListResponseTest {

    @Test
    fun createAccountCreditConfigurationListResponse() {
        val accountCreditConfigurationListResponse =
            AccountCreditConfigurationListResponse.builder()
                .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .collectionsConfiguration(
                    AccountCreditConfigurationListResponse.CollectionsConfiguration.builder()
                        .billingPeriod(123L)
                        .paymentPeriod(123L)
                        .externalBankAccountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .creditLimit(123L)
                .build()
        assertThat(accountCreditConfigurationListResponse).isNotNull
        assertThat(accountCreditConfigurationListResponse.token())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountCreditConfigurationListResponse.collectionsConfiguration())
            .contains(
                AccountCreditConfigurationListResponse.CollectionsConfiguration.builder()
                    .billingPeriod(123L)
                    .paymentPeriod(123L)
                    .externalBankAccountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(accountCreditConfigurationListResponse.creditLimit()).contains(123L)
    }
}
