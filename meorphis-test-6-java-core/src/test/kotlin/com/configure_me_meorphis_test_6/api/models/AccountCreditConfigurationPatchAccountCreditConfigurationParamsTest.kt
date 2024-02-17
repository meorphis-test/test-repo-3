// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import com.configure_me_meorphis_test_6.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountCreditConfigurationPatchAccountCreditConfigurationParamsTest {

    @Test
    fun createAccountCreditConfigurationPatchAccountCreditConfigurationParams() {
        AccountCreditConfigurationPatchAccountCreditConfigurationParams.builder()
            .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .billingPeriod(123L)
            .creditLimit(123L)
            .externalBankAccountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .paymentPeriod(123L)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AccountCreditConfigurationPatchAccountCreditConfigurationParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .billingPeriod(123L)
                .creditLimit(123L)
                .externalBankAccountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentPeriod(123L)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.billingPeriod()).isEqualTo(123L)
        assertThat(body.creditLimit()).isEqualTo(123L)
        assertThat(body.externalBankAccountToken())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.paymentPeriod()).isEqualTo(123L)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AccountCreditConfigurationPatchAccountCreditConfigurationParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params =
            AccountCreditConfigurationPatchAccountCreditConfigurationParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(params).isNotNull
        // path param "accountToken"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
