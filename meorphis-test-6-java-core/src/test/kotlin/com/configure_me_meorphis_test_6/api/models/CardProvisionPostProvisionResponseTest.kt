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
import com.configure_me_meorphis_test_6.api.models.CardProvisionPostProvisionResponse

class CardProvisionPostProvisionResponseTest {

    @Test
    fun createCardProvisionPostProvisionResponse() {
      val cardProvisionPostProvisionResponse = CardProvisionPostProvisionResponse.builder()
          .provisioningPayload("string")
          .build()
      assertThat(cardProvisionPostProvisionResponse).isNotNull
      assertThat(cardProvisionPostProvisionResponse.provisioningPayload()).contains("string")
    }
}
