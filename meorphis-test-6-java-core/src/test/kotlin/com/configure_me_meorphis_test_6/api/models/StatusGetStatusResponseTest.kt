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
import com.configure_me_meorphis_test_6.api.models.StatusGetStatusResponse

class StatusGetStatusResponseTest {

    @Test
    fun createStatusGetStatusResponse() {
      val statusGetStatusResponse = StatusGetStatusResponse.builder()
          .message("string")
          .build()
      assertThat(statusGetStatusResponse).isNotNull
      assertThat(statusGetStatusResponse.message()).contains("string")
    }
}
