// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.models

import com.configure_me_meorphis_test_6.api.core.ExcludeMissing
import com.configure_me_meorphis_test_6.api.core.JsonField
import com.configure_me_meorphis_test_6.api.core.JsonMissing
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.NoAutoDetect
import com.configure_me_meorphis_test_6.api.core.toUnmodifiable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import java.util.Optional

@JsonDeserialize(
    builder = AccountCreditConfigurationPatchAccountCreditConfigurationResponse.Builder::class
)
@NoAutoDetect
class AccountCreditConfigurationPatchAccountCreditConfigurationResponse
private constructor(
    private val collectionsConfiguration: JsonField<CollectionsConfiguration>,
    private val creditLimit: JsonField<Long>,
    private val token: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun collectionsConfiguration(): Optional<CollectionsConfiguration> =
        Optional.ofNullable(collectionsConfiguration.getNullable("collections_configuration"))

    /** Credit limit extended to the Account */
    fun creditLimit(): Optional<Long> = Optional.ofNullable(creditLimit.getNullable("credit_limit"))

    /** Account token */
    fun token(): String = token.getRequired("token")

    @JsonProperty("collections_configuration")
    @ExcludeMissing
    fun _collectionsConfiguration() = collectionsConfiguration

    /** Credit limit extended to the Account */
    @JsonProperty("credit_limit") @ExcludeMissing fun _creditLimit() = creditLimit

    /** Account token */
    @JsonProperty("token") @ExcludeMissing fun _token() = token

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AccountCreditConfigurationPatchAccountCreditConfigurationResponse = apply {
        if (!validated) {
            collectionsConfiguration().map { it.validate() }
            creditLimit()
            token()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountCreditConfigurationPatchAccountCreditConfigurationResponse &&
            this.collectionsConfiguration == other.collectionsConfiguration &&
            this.creditLimit == other.creditLimit &&
            this.token == other.token &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    collectionsConfiguration,
                    creditLimit,
                    token,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "AccountCreditConfigurationPatchAccountCreditConfigurationResponse{collectionsConfiguration=$collectionsConfiguration, creditLimit=$creditLimit, token=$token, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var collectionsConfiguration: JsonField<CollectionsConfiguration> = JsonMissing.of()
        private var creditLimit: JsonField<Long> = JsonMissing.of()
        private var token: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            accountCreditConfigurationPatchAccountCreditConfigurationResponse:
                AccountCreditConfigurationPatchAccountCreditConfigurationResponse
        ) = apply {
            this.collectionsConfiguration =
                accountCreditConfigurationPatchAccountCreditConfigurationResponse
                    .collectionsConfiguration
            this.creditLimit =
                accountCreditConfigurationPatchAccountCreditConfigurationResponse.creditLimit
            this.token = accountCreditConfigurationPatchAccountCreditConfigurationResponse.token
            additionalProperties(
                accountCreditConfigurationPatchAccountCreditConfigurationResponse
                    .additionalProperties
            )
        }

        fun collectionsConfiguration(collectionsConfiguration: CollectionsConfiguration) =
            collectionsConfiguration(JsonField.of(collectionsConfiguration))

        @JsonProperty("collections_configuration")
        @ExcludeMissing
        fun collectionsConfiguration(
            collectionsConfiguration: JsonField<CollectionsConfiguration>
        ) = apply { this.collectionsConfiguration = collectionsConfiguration }

        /** Credit limit extended to the Account */
        fun creditLimit(creditLimit: Long) = creditLimit(JsonField.of(creditLimit))

        /** Credit limit extended to the Account */
        @JsonProperty("credit_limit")
        @ExcludeMissing
        fun creditLimit(creditLimit: JsonField<Long>) = apply { this.creditLimit = creditLimit }

        /** Account token */
        fun token(token: String) = token(JsonField.of(token))

        /** Account token */
        @JsonProperty("token")
        @ExcludeMissing
        fun token(token: JsonField<String>) = apply { this.token = token }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): AccountCreditConfigurationPatchAccountCreditConfigurationResponse =
            AccountCreditConfigurationPatchAccountCreditConfigurationResponse(
                collectionsConfiguration,
                creditLimit,
                token,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CollectionsConfiguration.Builder::class)
    @NoAutoDetect
    class CollectionsConfiguration
    private constructor(
        private val billingPeriod: JsonField<Long>,
        private val externalBankAccountToken: JsonField<String>,
        private val paymentPeriod: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** Number of days within the billing period */
        fun billingPeriod(): Long = billingPeriod.getRequired("billing_period")

        /** The external bank account token to use for auto-collections */
        fun externalBankAccountToken(): Optional<String> =
            Optional.ofNullable(externalBankAccountToken.getNullable("external_bank_account_token"))

        /** Number of days after the billing period ends that a payment is required */
        fun paymentPeriod(): Long = paymentPeriod.getRequired("payment_period")

        /** Number of days within the billing period */
        @JsonProperty("billing_period") @ExcludeMissing fun _billingPeriod() = billingPeriod

        /** The external bank account token to use for auto-collections */
        @JsonProperty("external_bank_account_token")
        @ExcludeMissing
        fun _externalBankAccountToken() = externalBankAccountToken

        /** Number of days after the billing period ends that a payment is required */
        @JsonProperty("payment_period") @ExcludeMissing fun _paymentPeriod() = paymentPeriod

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): CollectionsConfiguration = apply {
            if (!validated) {
                billingPeriod()
                externalBankAccountToken()
                paymentPeriod()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CollectionsConfiguration &&
                this.billingPeriod == other.billingPeriod &&
                this.externalBankAccountToken == other.externalBankAccountToken &&
                this.paymentPeriod == other.paymentPeriod &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        billingPeriod,
                        externalBankAccountToken,
                        paymentPeriod,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CollectionsConfiguration{billingPeriod=$billingPeriod, externalBankAccountToken=$externalBankAccountToken, paymentPeriod=$paymentPeriod, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var billingPeriod: JsonField<Long> = JsonMissing.of()
            private var externalBankAccountToken: JsonField<String> = JsonMissing.of()
            private var paymentPeriod: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(collectionsConfiguration: CollectionsConfiguration) = apply {
                this.billingPeriod = collectionsConfiguration.billingPeriod
                this.externalBankAccountToken = collectionsConfiguration.externalBankAccountToken
                this.paymentPeriod = collectionsConfiguration.paymentPeriod
                additionalProperties(collectionsConfiguration.additionalProperties)
            }

            /** Number of days within the billing period */
            fun billingPeriod(billingPeriod: Long) = billingPeriod(JsonField.of(billingPeriod))

            /** Number of days within the billing period */
            @JsonProperty("billing_period")
            @ExcludeMissing
            fun billingPeriod(billingPeriod: JsonField<Long>) = apply {
                this.billingPeriod = billingPeriod
            }

            /** The external bank account token to use for auto-collections */
            fun externalBankAccountToken(externalBankAccountToken: String) =
                externalBankAccountToken(JsonField.of(externalBankAccountToken))

            /** The external bank account token to use for auto-collections */
            @JsonProperty("external_bank_account_token")
            @ExcludeMissing
            fun externalBankAccountToken(externalBankAccountToken: JsonField<String>) = apply {
                this.externalBankAccountToken = externalBankAccountToken
            }

            /** Number of days after the billing period ends that a payment is required */
            fun paymentPeriod(paymentPeriod: Long) = paymentPeriod(JsonField.of(paymentPeriod))

            /** Number of days after the billing period ends that a payment is required */
            @JsonProperty("payment_period")
            @ExcludeMissing
            fun paymentPeriod(paymentPeriod: JsonField<Long>) = apply {
                this.paymentPeriod = paymentPeriod
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): CollectionsConfiguration =
                CollectionsConfiguration(
                    billingPeriod,
                    externalBankAccountToken,
                    paymentPeriod,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
