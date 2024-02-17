// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import com.configure_me_meorphis_test_6.api.TestServerExtension
import com.configure_me_meorphis_test_6.api.client.MeorphisTest6Client
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.core.JsonNull
import com.configure_me_meorphis_test_6.api.core.JsonString
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.http.BinaryResponseContent
import com.configure_me_meorphis_test_6.api.services.blocking.StatusService
import com.configure_me_meorphis_test_6.api.models.*

@ExtendWith(TestServerExtension::class)
class StatusServiceTest {

    @Test
    fun callGetStatus() {
      val client = MeorphisTest6OkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val statusService = client.statuses()
      val statusGetStatusResponse = statusService.getStatus(StatusGetStatusParams.builder().build())
      println(statusGetStatusResponse)
      statusGetStatusResponse.validate()
    }
}
