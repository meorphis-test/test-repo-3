// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatusGetStatusResponseTest {

    @Test
    fun createStatusGetStatusResponse() {
        val statusGetStatusResponse = StatusGetStatusResponse.builder().message("string").build()
        assertThat(statusGetStatusResponse).isNotNull
        assertThat(statusGetStatusResponse.message()).contains("string")
    }
}
