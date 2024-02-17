// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardFinancialTransactionGetFinancialTransactionByTokenResponseTest {

    @Test
    fun createCardFinancialTransactionGetFinancialTransactionByTokenResponse() {
        val cardFinancialTransactionGetFinancialTransactionByTokenResponse =
            CardFinancialTransactionGetFinancialTransactionByTokenResponse.builder()
                .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .category(
                    CardFinancialTransactionGetFinancialTransactionByTokenResponse.Category.CARD
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .currency("string")
                .descriptor("string")
                .events(
                    listOf(
                        CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event
                            .builder()
                            .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .amount(123L)
                            .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .result(
                                CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event
                                    .Result
                                    .APPROVED
                            )
                            .type(
                                CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event
                                    .Type
                                    .ACH_INSUFFICIENT_FUNDS
                            )
                            .build()
                    )
                )
                .pendingAmount(123L)
                .result(
                    CardFinancialTransactionGetFinancialTransactionByTokenResponse.Result.APPROVED
                )
                .settledAmount(123L)
                .status(
                    CardFinancialTransactionGetFinancialTransactionByTokenResponse.Status.DECLINED
                )
                .updated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse).isNotNull
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.token())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.category())
            .isEqualTo(CardFinancialTransactionGetFinancialTransactionByTokenResponse.Category.CARD)
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.currency())
            .isEqualTo("string")
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.descriptor())
            .isEqualTo("string")
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.events())
            .containsExactly(
                CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event.builder()
                    .token("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .amount(123L)
                    .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .result(
                        CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event.Result
                            .APPROVED
                    )
                    .type(
                        CardFinancialTransactionGetFinancialTransactionByTokenResponse.Event.Type
                            .ACH_INSUFFICIENT_FUNDS
                    )
                    .build()
            )
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.pendingAmount())
            .isEqualTo(123L)
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.result())
            .isEqualTo(
                CardFinancialTransactionGetFinancialTransactionByTokenResponse.Result.APPROVED
            )
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.settledAmount())
            .isEqualTo(123L)
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.status())
            .isEqualTo(
                CardFinancialTransactionGetFinancialTransactionByTokenResponse.Status.DECLINED
            )
        assertThat(cardFinancialTransactionGetFinancialTransactionByTokenResponse.updated())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
