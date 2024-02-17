// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import java.util.UUID
import com.configure_me_meorphis_test_6.api.core.BaseDeserializer
import com.configure_me_meorphis_test_6.api.core.BaseSerializer
import com.configure_me_meorphis_test_6.api.core.getOrThrow
import com.configure_me_meorphis_test_6.api.core.ExcludeMissing
import com.configure_me_meorphis_test_6.api.core.JsonField
import com.configure_me_meorphis_test_6.api.core.JsonMissing
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.toUnmodifiable
import com.configure_me_meorphis_test_6.api.core.NoAutoDetect
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6InvalidDataException
import com.configure_me_meorphis_test_6.api.models.*

class CardFinancialTransactionGetFinancialTransactionByTokenParams constructor(
  private val cardToken: String,
  private val financialTransactionToken: String,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,

) {

    fun cardToken(): String = cardToken

    fun financialTransactionToken(): String = financialTransactionToken

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic
    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> cardToken
          1 -> financialTransactionToken
          else -> ""
      }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is CardFinancialTransactionGetFinancialTransactionByTokenParams &&
          this.cardToken == other.cardToken &&
          this.financialTransactionToken == other.financialTransactionToken &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
      return Objects.hash(
          cardToken,
          financialTransactionToken,
          additionalQueryParams,
          additionalHeaders,
      )
    }

    override fun toString() = "CardFinancialTransactionGetFinancialTransactionByTokenParams{cardToken=$cardToken, financialTransactionToken=$financialTransactionToken, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic
        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var cardToken: String? = null
        private var financialTransactionToken: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        @JvmSynthetic
        internal fun from(cardFinancialTransactionGetFinancialTransactionByTokenParams: CardFinancialTransactionGetFinancialTransactionByTokenParams) = apply {
            this.cardToken = cardFinancialTransactionGetFinancialTransactionByTokenParams.cardToken
            this.financialTransactionToken = cardFinancialTransactionGetFinancialTransactionByTokenParams.financialTransactionToken
            additionalQueryParams(cardFinancialTransactionGetFinancialTransactionByTokenParams.additionalQueryParams)
            additionalHeaders(cardFinancialTransactionGetFinancialTransactionByTokenParams.additionalHeaders)
        }

        fun cardToken(cardToken: String) = apply {
            this.cardToken = cardToken
        }

        fun financialTransactionToken(financialTransactionToken: String) = apply {
            this.financialTransactionToken = financialTransactionToken
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply {
            this.additionalHeaders.put(name, mutableListOf())
        }

        fun build(): CardFinancialTransactionGetFinancialTransactionByTokenParams = CardFinancialTransactionGetFinancialTransactionByTokenParams(
            checkNotNull(cardToken) {
                "`cardToken` is required but was not set"
            },
            checkNotNull(financialTransactionToken) {
                "`financialTransactionToken` is required but was not set"
            },
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
        )
    }
}
