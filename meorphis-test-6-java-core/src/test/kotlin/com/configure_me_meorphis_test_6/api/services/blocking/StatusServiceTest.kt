// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking

import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class StatusServiceTest {

    @Test
    fun callGetStatus() {
        val client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statusService = client.statuses()
        val statusGetStatusResponse =
            statusService.getStatus(StatusGetStatusParams.builder().build())
        println(statusGetStatusResponse)
        statusGetStatusResponse.validate()
    }
}
