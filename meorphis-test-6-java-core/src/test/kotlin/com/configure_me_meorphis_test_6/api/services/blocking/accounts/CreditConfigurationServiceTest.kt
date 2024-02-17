// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking.accounts

import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CreditConfigurationServiceTest {

    @Test
    fun callList() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val creditConfigurationService = client.accounts().creditConfigurations()
        val accountCreditConfigurationListResponse =
            creditConfigurationService.list(
                AccountCreditConfigurationListParams.builder()
                    .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(accountCreditConfigurationListResponse)
        accountCreditConfigurationListResponse.validate()
    }

    @Test
    fun callPatchAccountCreditConfiguration() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val creditConfigurationService = client.accounts().creditConfigurations()
        val accountCreditConfigurationPatchAccountCreditConfigurationResponse =
            creditConfigurationService.patchAccountCreditConfiguration(
                AccountCreditConfigurationPatchAccountCreditConfigurationParams.builder()
                    .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .billingPeriod(123L)
                    .creditLimit(123L)
                    .externalBankAccountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .paymentPeriod(123L)
                    .build()
            )
        println(accountCreditConfigurationPatchAccountCreditConfigurationResponse)
        accountCreditConfigurationPatchAccountCreditConfigurationResponse.validate()
    }
}
