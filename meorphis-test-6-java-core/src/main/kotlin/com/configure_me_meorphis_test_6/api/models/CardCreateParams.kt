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

class CardCreateParams constructor(
  private val type: Type,
  private val accountToken: String?,
  private val cardProgramToken: String?,
  private val carrier: Carrier?,
  private val digitalCardArtToken: String?,
  private val expMonth: String?,
  private val expYear: String?,
  private val memo: String?,
  private val pin: String?,
  private val productId: String?,
  private val shippingAddress: ShippingAddress?,
  private val shippingMethod: ShippingMethod?,
  private val spendLimit: Long?,
  private val spendLimitDuration: SpendLimitDuration?,
  private val state: State?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun type(): Type = type

    fun accountToken(): Optional<String> = Optional.ofNullable(accountToken)

    fun cardProgramToken(): Optional<String> = Optional.ofNullable(cardProgramToken)

    fun carrier(): Optional<Carrier> = Optional.ofNullable(carrier)

    fun digitalCardArtToken(): Optional<String> = Optional.ofNullable(digitalCardArtToken)

    fun expMonth(): Optional<String> = Optional.ofNullable(expMonth)

    fun expYear(): Optional<String> = Optional.ofNullable(expYear)

    fun memo(): Optional<String> = Optional.ofNullable(memo)

    fun pin(): Optional<String> = Optional.ofNullable(pin)

    fun productId(): Optional<String> = Optional.ofNullable(productId)

    fun shippingAddress(): Optional<ShippingAddress> = Optional.ofNullable(shippingAddress)

    fun shippingMethod(): Optional<ShippingMethod> = Optional.ofNullable(shippingMethod)

    fun spendLimit(): Optional<Long> = Optional.ofNullable(spendLimit)

    fun spendLimitDuration(): Optional<SpendLimitDuration> = Optional.ofNullable(spendLimitDuration)

    fun state(): Optional<State> = Optional.ofNullable(state)

    @JvmSynthetic
    internal fun getBody(): CardCreateBody {
      return CardCreateBody(
          type,
          accountToken,
          cardProgramToken,
          carrier,
          digitalCardArtToken,
          expMonth,
          expYear,
          memo,
          pin,
          productId,
          shippingAddress,
          shippingMethod,
          spendLimit,
          spendLimitDuration,
          state,
          additionalBodyProperties,
      )
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    @JvmSynthetic
    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = CardCreateBody.Builder::class)
    @NoAutoDetect
    class CardCreateBody internal constructor(
      private val type: Type?,
      private val accountToken: String?,
      private val cardProgramToken: String?,
      private val carrier: Carrier?,
      private val digitalCardArtToken: String?,
      private val expMonth: String?,
      private val expYear: String?,
      private val memo: String?,
      private val pin: String?,
      private val productId: String?,
      private val shippingAddress: ShippingAddress?,
      private val shippingMethod: ShippingMethod?,
      private val spendLimit: Long?,
      private val spendLimitDuration: SpendLimitDuration?,
      private val state: State?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        /**
         * Card types:
         *
         * - `VIRTUAL` - Card will authorize at any merchant and can be added to a digital
         *   wallet like Apple Pay or Google Pay (if the card program is digital
         *   wallet-enabled).
         * - `PHYSICAL` - Manufactured and sent to the cardholder. We offer white label
         *   branding, credit, ATM, PIN debit, chip/EMV, NFC and magstripe functionality.
         *   Reach out at [acme.com/contact](https://acme.com/contact) for more
         *   information.
         * - `SINGLE_USE` - Card is closed upon first successful authorization.
         * - `MERCHANT_LOCKED` - _[Deprecated]_ Card is locked to the first merchant that
         *   successfully authorizes the card.
         */
        @JsonProperty("type")
        fun type(): Type? = type

        /**
         * Globally unique identifier for the account that the card will be associated
         * with. Required for programs enrolling users using the
         * [/account_holders endpoint](https://docs.acme.com/docs/account-holders-kyc). See
         * [Managing Your Program](doc:managing-your-program) for more information.
         */
        @JsonProperty("account_token")
        fun accountToken(): String? = accountToken

        /**
         * For card programs with more than one BIN range. This must be configured with
         * Acme before use. Identifies the card program/BIN range under which to create the
         * card. If omitted, will utilize the program's default `card_program_token`. In
         * Sandbox, use 00000000-0000-0000-1000-000000000000 and
         * 00000000-0000-0000-2000-000000000000 to test creating cards on specific card
         * programs.
         */
        @JsonProperty("card_program_token")
        fun cardProgramToken(): String? = cardProgramToken

        @JsonProperty("carrier")
        fun carrier(): Carrier? = carrier

        /**
         * Specifies the digital card art to be displayed in the user’s digital wallet
         * after tokenization. This artwork must be approved by Mastercard and configured
         * by Acme to use. See
         * [Flexible Card Art Guide](https://docs.acme.com/docs/about-digital-wallets#flexible-card-art).
         */
        @JsonProperty("digital_card_art_token")
        fun digitalCardArtToken(): String? = digitalCardArtToken

        /**
         * Two digit (MM) expiry month. If neither `exp_month` nor `exp_year` is provided,
         * an expiration date will be generated.
         */
        @JsonProperty("exp_month")
        fun expMonth(): String? = expMonth

        /**
         * Four digit (yyyy) expiry year. If neither `exp_month` nor `exp_year` is
         * provided, an expiration date will be generated.
         */
        @JsonProperty("exp_year")
        fun expYear(): String? = expYear

        /**
         * Friendly name to identify the card. We recommend against using this field to
         * store JSON data as it can cause unexpected behavior.
         */
        @JsonProperty("memo")
        fun memo(): String? = memo

        /**
         * Encrypted PIN block (in base64). Only applies to cards of type `PHYSICAL` and
         * `VIRTUAL`. See
         * [Encrypted PIN Block](https://docs.acme.com/docs/cards#encrypted-pin-block-enterprise).
         */
        @JsonProperty("pin")
        fun pin(): String? = pin

        /**
         * Only applicable to cards of type `PHYSICAL`. This must be configured with Acme
         * before use. Specifies the configuration (i.e., physical card art) that the card
         * should be manufactured with.
         */
        @JsonProperty("product_id")
        fun productId(): String? = productId

        @JsonProperty("shipping_address")
        fun shippingAddress(): ShippingAddress? = shippingAddress

        /**
         * Shipping method for the card. Only applies to cards of type PHYSICAL. Use of
         * options besides `STANDARD` require additional permissions.
         *
         * - `STANDARD` - USPS regular mail or similar international option, with no
         *   tracking
         * - `STANDARD_WITH_TRACKING` - USPS regular mail or similar international option,
         *   with tracking
         * - `PRIORITY` - USPS Priority, 1-3 day shipping, with tracking
         * - `EXPRESS` - FedEx Express, 3-day shipping, with tracking
         * - `2_DAY` - FedEx 2-day shipping, with tracking
         * - `EXPEDITED` - FedEx Standard Overnight or similar international option, with
         *   tracking
         */
        @JsonProperty("shipping_method")
        fun shippingMethod(): ShippingMethod? = shippingMethod

        /**
         * Amount (in cents) to limit approved authorizations. Transaction requests above
         * the spend limit will be declined. Note that a spend limit of 0 is effectively no
         * limit, and should only be used to reset or remove a prior limit. Only a limit of
         * 1 or above will result in declined transactions due to checks against the card
         * limit.
         */
        @JsonProperty("spend_limit")
        fun spendLimit(): Long? = spendLimit

        /**
         * Spend limit duration values:
         *
         * - `ANNUALLY` - Card will authorize transactions up to spend limit in a calendar
         *   year.
         * - `FOREVER` - Card will authorize only up to spend limit for the entire lifetime
         *   of the card.
         * - `MONTHLY` - Card will authorize transactions up to spend limit for the
         *   trailing month. Month is calculated as this calendar date one month prior.
         * - `TRANSACTION` - Card will authorize multiple transactions if each individual
         *   transaction is under the spend limit.
         */
        @JsonProperty("spend_limit_duration")
        fun spendLimitDuration(): SpendLimitDuration? = spendLimitDuration

        /**
         * Card state values:
         *
         * - `OPEN` - Card will approve authorizations (if they match card and account
         *   parameters).
         * - `PAUSED` - Card will decline authorizations, but can be resumed at a later
         *   time.
         */
        @JsonProperty("state")
        fun state(): State? = state

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is CardCreateBody &&
              this.type == other.type &&
              this.accountToken == other.accountToken &&
              this.cardProgramToken == other.cardProgramToken &&
              this.carrier == other.carrier &&
              this.digitalCardArtToken == other.digitalCardArtToken &&
              this.expMonth == other.expMonth &&
              this.expYear == other.expYear &&
              this.memo == other.memo &&
              this.pin == other.pin &&
              this.productId == other.productId &&
              this.shippingAddress == other.shippingAddress &&
              this.shippingMethod == other.shippingMethod &&
              this.spendLimit == other.spendLimit &&
              this.spendLimitDuration == other.spendLimitDuration &&
              this.state == other.state &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                type,
                accountToken,
                cardProgramToken,
                carrier,
                digitalCardArtToken,
                expMonth,
                expYear,
                memo,
                pin,
                productId,
                shippingAddress,
                shippingMethod,
                spendLimit,
                spendLimitDuration,
                state,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "CardCreateBody{type=$type, accountToken=$accountToken, cardProgramToken=$cardProgramToken, carrier=$carrier, digitalCardArtToken=$digitalCardArtToken, expMonth=$expMonth, expYear=$expYear, memo=$memo, pin=$pin, productId=$productId, shippingAddress=$shippingAddress, shippingMethod=$shippingMethod, spendLimit=$spendLimit, spendLimitDuration=$spendLimitDuration, state=$state, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var type: Type? = null
            private var accountToken: String? = null
            private var cardProgramToken: String? = null
            private var carrier: Carrier? = null
            private var digitalCardArtToken: String? = null
            private var expMonth: String? = null
            private var expYear: String? = null
            private var memo: String? = null
            private var pin: String? = null
            private var productId: String? = null
            private var shippingAddress: ShippingAddress? = null
            private var shippingMethod: ShippingMethod? = null
            private var spendLimit: Long? = null
            private var spendLimitDuration: SpendLimitDuration? = null
            private var state: State? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cardCreateBody: CardCreateBody) = apply {
                this.type = cardCreateBody.type
                this.accountToken = cardCreateBody.accountToken
                this.cardProgramToken = cardCreateBody.cardProgramToken
                this.carrier = cardCreateBody.carrier
                this.digitalCardArtToken = cardCreateBody.digitalCardArtToken
                this.expMonth = cardCreateBody.expMonth
                this.expYear = cardCreateBody.expYear
                this.memo = cardCreateBody.memo
                this.pin = cardCreateBody.pin
                this.productId = cardCreateBody.productId
                this.shippingAddress = cardCreateBody.shippingAddress
                this.shippingMethod = cardCreateBody.shippingMethod
                this.spendLimit = cardCreateBody.spendLimit
                this.spendLimitDuration = cardCreateBody.spendLimitDuration
                this.state = cardCreateBody.state
                additionalProperties(cardCreateBody.additionalProperties)
            }

            /**
             * Card types:
             *
             * - `VIRTUAL` - Card will authorize at any merchant and can be added to a digital
             *   wallet like Apple Pay or Google Pay (if the card program is digital
             *   wallet-enabled).
             * - `PHYSICAL` - Manufactured and sent to the cardholder. We offer white label
             *   branding, credit, ATM, PIN debit, chip/EMV, NFC and magstripe functionality.
             *   Reach out at [acme.com/contact](https://acme.com/contact) for more
             *   information.
             * - `SINGLE_USE` - Card is closed upon first successful authorization.
             * - `MERCHANT_LOCKED` - _[Deprecated]_ Card is locked to the first merchant that
             *   successfully authorizes the card.
             */
            @JsonProperty("type")
            fun type(type: Type) = apply {
                this.type = type
            }

            /**
             * Globally unique identifier for the account that the card will be associated
             * with. Required for programs enrolling users using the
             * [/account_holders endpoint](https://docs.acme.com/docs/account-holders-kyc). See
             * [Managing Your Program](doc:managing-your-program) for more information.
             */
            @JsonProperty("account_token")
            fun accountToken(accountToken: String) = apply {
                this.accountToken = accountToken
            }

            /**
             * For card programs with more than one BIN range. This must be configured with
             * Acme before use. Identifies the card program/BIN range under which to create the
             * card. If omitted, will utilize the program's default `card_program_token`. In
             * Sandbox, use 00000000-0000-0000-1000-000000000000 and
             * 00000000-0000-0000-2000-000000000000 to test creating cards on specific card
             * programs.
             */
            @JsonProperty("card_program_token")
            fun cardProgramToken(cardProgramToken: String) = apply {
                this.cardProgramToken = cardProgramToken
            }

            @JsonProperty("carrier")
            fun carrier(carrier: Carrier) = apply {
                this.carrier = carrier
            }

            /**
             * Specifies the digital card art to be displayed in the user’s digital wallet
             * after tokenization. This artwork must be approved by Mastercard and configured
             * by Acme to use. See
             * [Flexible Card Art Guide](https://docs.acme.com/docs/about-digital-wallets#flexible-card-art).
             */
            @JsonProperty("digital_card_art_token")
            fun digitalCardArtToken(digitalCardArtToken: String) = apply {
                this.digitalCardArtToken = digitalCardArtToken
            }

            /**
             * Two digit (MM) expiry month. If neither `exp_month` nor `exp_year` is provided,
             * an expiration date will be generated.
             */
            @JsonProperty("exp_month")
            fun expMonth(expMonth: String) = apply {
                this.expMonth = expMonth
            }

            /**
             * Four digit (yyyy) expiry year. If neither `exp_month` nor `exp_year` is
             * provided, an expiration date will be generated.
             */
            @JsonProperty("exp_year")
            fun expYear(expYear: String) = apply {
                this.expYear = expYear
            }

            /**
             * Friendly name to identify the card. We recommend against using this field to
             * store JSON data as it can cause unexpected behavior.
             */
            @JsonProperty("memo")
            fun memo(memo: String) = apply {
                this.memo = memo
            }

            /**
             * Encrypted PIN block (in base64). Only applies to cards of type `PHYSICAL` and
             * `VIRTUAL`. See
             * [Encrypted PIN Block](https://docs.acme.com/docs/cards#encrypted-pin-block-enterprise).
             */
            @JsonProperty("pin")
            fun pin(pin: String) = apply {
                this.pin = pin
            }

            /**
             * Only applicable to cards of type `PHYSICAL`. This must be configured with Acme
             * before use. Specifies the configuration (i.e., physical card art) that the card
             * should be manufactured with.
             */
            @JsonProperty("product_id")
            fun productId(productId: String) = apply {
                this.productId = productId
            }

            @JsonProperty("shipping_address")
            fun shippingAddress(shippingAddress: ShippingAddress) = apply {
                this.shippingAddress = shippingAddress
            }

            /**
             * Shipping method for the card. Only applies to cards of type PHYSICAL. Use of
             * options besides `STANDARD` require additional permissions.
             *
             * - `STANDARD` - USPS regular mail or similar international option, with no
             *   tracking
             * - `STANDARD_WITH_TRACKING` - USPS regular mail or similar international option,
             *   with tracking
             * - `PRIORITY` - USPS Priority, 1-3 day shipping, with tracking
             * - `EXPRESS` - FedEx Express, 3-day shipping, with tracking
             * - `2_DAY` - FedEx 2-day shipping, with tracking
             * - `EXPEDITED` - FedEx Standard Overnight or similar international option, with
             *   tracking
             */
            @JsonProperty("shipping_method")
            fun shippingMethod(shippingMethod: ShippingMethod) = apply {
                this.shippingMethod = shippingMethod
            }

            /**
             * Amount (in cents) to limit approved authorizations. Transaction requests above
             * the spend limit will be declined. Note that a spend limit of 0 is effectively no
             * limit, and should only be used to reset or remove a prior limit. Only a limit of
             * 1 or above will result in declined transactions due to checks against the card
             * limit.
             */
            @JsonProperty("spend_limit")
            fun spendLimit(spendLimit: Long) = apply {
                this.spendLimit = spendLimit
            }

            /**
             * Spend limit duration values:
             *
             * - `ANNUALLY` - Card will authorize transactions up to spend limit in a calendar
             *   year.
             * - `FOREVER` - Card will authorize only up to spend limit for the entire lifetime
             *   of the card.
             * - `MONTHLY` - Card will authorize transactions up to spend limit for the
             *   trailing month. Month is calculated as this calendar date one month prior.
             * - `TRANSACTION` - Card will authorize multiple transactions if each individual
             *   transaction is under the spend limit.
             */
            @JsonProperty("spend_limit_duration")
            fun spendLimitDuration(spendLimitDuration: SpendLimitDuration) = apply {
                this.spendLimitDuration = spendLimitDuration
            }

            /**
             * Card state values:
             *
             * - `OPEN` - Card will approve authorizations (if they match card and account
             *   parameters).
             * - `PAUSED` - Card will decline authorizations, but can be resumed at a later
             *   time.
             */
            @JsonProperty("state")
            fun state(state: State) = apply {
                this.state = state
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

            fun build(): CardCreateBody = CardCreateBody(
                checkNotNull(type) {
                    "`type` is required but was not set"
                },
                accountToken,
                cardProgramToken,
                carrier,
                digitalCardArtToken,
                expMonth,
                expYear,
                memo,
                pin,
                productId,
                shippingAddress,
                shippingMethod,
                spendLimit,
                spendLimitDuration,
                state,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is CardCreateParams &&
          this.type == other.type &&
          this.accountToken == other.accountToken &&
          this.cardProgramToken == other.cardProgramToken &&
          this.carrier == other.carrier &&
          this.digitalCardArtToken == other.digitalCardArtToken &&
          this.expMonth == other.expMonth &&
          this.expYear == other.expYear &&
          this.memo == other.memo &&
          this.pin == other.pin &&
          this.productId == other.productId &&
          this.shippingAddress == other.shippingAddress &&
          this.shippingMethod == other.shippingMethod &&
          this.spendLimit == other.spendLimit &&
          this.spendLimitDuration == other.spendLimitDuration &&
          this.state == other.state &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          type,
          accountToken,
          cardProgramToken,
          carrier,
          digitalCardArtToken,
          expMonth,
          expYear,
          memo,
          pin,
          productId,
          shippingAddress,
          shippingMethod,
          spendLimit,
          spendLimitDuration,
          state,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "CardCreateParams{type=$type, accountToken=$accountToken, cardProgramToken=$cardProgramToken, carrier=$carrier, digitalCardArtToken=$digitalCardArtToken, expMonth=$expMonth, expYear=$expYear, memo=$memo, pin=$pin, productId=$productId, shippingAddress=$shippingAddress, shippingMethod=$shippingMethod, spendLimit=$spendLimit, spendLimitDuration=$spendLimitDuration, state=$state, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic
        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var type: Type? = null
        private var accountToken: String? = null
        private var cardProgramToken: String? = null
        private var carrier: Carrier? = null
        private var digitalCardArtToken: String? = null
        private var expMonth: String? = null
        private var expYear: String? = null
        private var memo: String? = null
        private var pin: String? = null
        private var productId: String? = null
        private var shippingAddress: ShippingAddress? = null
        private var shippingMethod: ShippingMethod? = null
        private var spendLimit: Long? = null
        private var spendLimitDuration: SpendLimitDuration? = null
        private var state: State? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(cardCreateParams: CardCreateParams) = apply {
            this.type = cardCreateParams.type
            this.accountToken = cardCreateParams.accountToken
            this.cardProgramToken = cardCreateParams.cardProgramToken
            this.carrier = cardCreateParams.carrier
            this.digitalCardArtToken = cardCreateParams.digitalCardArtToken
            this.expMonth = cardCreateParams.expMonth
            this.expYear = cardCreateParams.expYear
            this.memo = cardCreateParams.memo
            this.pin = cardCreateParams.pin
            this.productId = cardCreateParams.productId
            this.shippingAddress = cardCreateParams.shippingAddress
            this.shippingMethod = cardCreateParams.shippingMethod
            this.spendLimit = cardCreateParams.spendLimit
            this.spendLimitDuration = cardCreateParams.spendLimitDuration
            this.state = cardCreateParams.state
            additionalQueryParams(cardCreateParams.additionalQueryParams)
            additionalHeaders(cardCreateParams.additionalHeaders)
            additionalBodyProperties(cardCreateParams.additionalBodyProperties)
        }

        /**
         * Card types:
         *
         * - `VIRTUAL` - Card will authorize at any merchant and can be added to a digital
         *   wallet like Apple Pay or Google Pay (if the card program is digital
         *   wallet-enabled).
         * - `PHYSICAL` - Manufactured and sent to the cardholder. We offer white label
         *   branding, credit, ATM, PIN debit, chip/EMV, NFC and magstripe functionality.
         *   Reach out at [acme.com/contact](https://acme.com/contact) for more
         *   information.
         * - `SINGLE_USE` - Card is closed upon first successful authorization.
         * - `MERCHANT_LOCKED` - _[Deprecated]_ Card is locked to the first merchant that
         *   successfully authorizes the card.
         */
        fun type(type: Type) = apply {
            this.type = type
        }

        /**
         * Globally unique identifier for the account that the card will be associated
         * with. Required for programs enrolling users using the
         * [/account_holders endpoint](https://docs.acme.com/docs/account-holders-kyc). See
         * [Managing Your Program](doc:managing-your-program) for more information.
         */
        fun accountToken(accountToken: String) = apply {
            this.accountToken = accountToken
        }

        /**
         * For card programs with more than one BIN range. This must be configured with
         * Acme before use. Identifies the card program/BIN range under which to create the
         * card. If omitted, will utilize the program's default `card_program_token`. In
         * Sandbox, use 00000000-0000-0000-1000-000000000000 and
         * 00000000-0000-0000-2000-000000000000 to test creating cards on specific card
         * programs.
         */
        fun cardProgramToken(cardProgramToken: String) = apply {
            this.cardProgramToken = cardProgramToken
        }

        fun carrier(carrier: Carrier) = apply {
            this.carrier = carrier
        }

        /**
         * Specifies the digital card art to be displayed in the user’s digital wallet
         * after tokenization. This artwork must be approved by Mastercard and configured
         * by Acme to use. See
         * [Flexible Card Art Guide](https://docs.acme.com/docs/about-digital-wallets#flexible-card-art).
         */
        fun digitalCardArtToken(digitalCardArtToken: String) = apply {
            this.digitalCardArtToken = digitalCardArtToken
        }

        /**
         * Two digit (MM) expiry month. If neither `exp_month` nor `exp_year` is provided,
         * an expiration date will be generated.
         */
        fun expMonth(expMonth: String) = apply {
            this.expMonth = expMonth
        }

        /**
         * Four digit (yyyy) expiry year. If neither `exp_month` nor `exp_year` is
         * provided, an expiration date will be generated.
         */
        fun expYear(expYear: String) = apply {
            this.expYear = expYear
        }

        /**
         * Friendly name to identify the card. We recommend against using this field to
         * store JSON data as it can cause unexpected behavior.
         */
        fun memo(memo: String) = apply {
            this.memo = memo
        }

        /**
         * Encrypted PIN block (in base64). Only applies to cards of type `PHYSICAL` and
         * `VIRTUAL`. See
         * [Encrypted PIN Block](https://docs.acme.com/docs/cards#encrypted-pin-block-enterprise).
         */
        fun pin(pin: String) = apply {
            this.pin = pin
        }

        /**
         * Only applicable to cards of type `PHYSICAL`. This must be configured with Acme
         * before use. Specifies the configuration (i.e., physical card art) that the card
         * should be manufactured with.
         */
        fun productId(productId: String) = apply {
            this.productId = productId
        }

        fun shippingAddress(shippingAddress: ShippingAddress) = apply {
            this.shippingAddress = shippingAddress
        }

        /**
         * Shipping method for the card. Only applies to cards of type PHYSICAL. Use of
         * options besides `STANDARD` require additional permissions.
         *
         * - `STANDARD` - USPS regular mail or similar international option, with no
         *   tracking
         * - `STANDARD_WITH_TRACKING` - USPS regular mail or similar international option,
         *   with tracking
         * - `PRIORITY` - USPS Priority, 1-3 day shipping, with tracking
         * - `EXPRESS` - FedEx Express, 3-day shipping, with tracking
         * - `2_DAY` - FedEx 2-day shipping, with tracking
         * - `EXPEDITED` - FedEx Standard Overnight or similar international option, with
         *   tracking
         */
        fun shippingMethod(shippingMethod: ShippingMethod) = apply {
            this.shippingMethod = shippingMethod
        }

        /**
         * Amount (in cents) to limit approved authorizations. Transaction requests above
         * the spend limit will be declined. Note that a spend limit of 0 is effectively no
         * limit, and should only be used to reset or remove a prior limit. Only a limit of
         * 1 or above will result in declined transactions due to checks against the card
         * limit.
         */
        fun spendLimit(spendLimit: Long) = apply {
            this.spendLimit = spendLimit
        }

        /**
         * Spend limit duration values:
         *
         * - `ANNUALLY` - Card will authorize transactions up to spend limit in a calendar
         *   year.
         * - `FOREVER` - Card will authorize only up to spend limit for the entire lifetime
         *   of the card.
         * - `MONTHLY` - Card will authorize transactions up to spend limit for the
         *   trailing month. Month is calculated as this calendar date one month prior.
         * - `TRANSACTION` - Card will authorize multiple transactions if each individual
         *   transaction is under the spend limit.
         */
        fun spendLimitDuration(spendLimitDuration: SpendLimitDuration) = apply {
            this.spendLimitDuration = spendLimitDuration
        }

        /**
         * Card state values:
         *
         * - `OPEN` - Card will approve authorizations (if they match card and account
         *   parameters).
         * - `PAUSED` - Card will decline authorizations, but can be resumed at a later
         *   time.
         */
        fun state(state: State) = apply {
            this.state = state
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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun build(): CardCreateParams = CardCreateParams(
            checkNotNull(type) {
                "`type` is required but was not set"
            },
            accountToken,
            cardProgramToken,
            carrier,
            digitalCardArtToken,
            expMonth,
            expYear,
            memo,
            pin,
            productId,
            shippingAddress,
            shippingMethod,
            spendLimit,
            spendLimitDuration,
            state,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>, ) {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Type &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val VIRTUAL = Type(JsonField.of("VIRTUAL"))

            @JvmField val PHYSICAL = Type(JsonField.of("PHYSICAL"))

            @JvmField val MERCHANT_LOCKED = Type(JsonField.of("MERCHANT_LOCKED"))

            @JvmField val SINGLE_USE = Type(JsonField.of("SINGLE_USE"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            VIRTUAL,
            PHYSICAL,
            MERCHANT_LOCKED,
            SINGLE_USE,
        }

        enum class Value {
            VIRTUAL,
            PHYSICAL,
            MERCHANT_LOCKED,
            SINGLE_USE,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            VIRTUAL -> Value.VIRTUAL
            PHYSICAL -> Value.PHYSICAL
            MERCHANT_LOCKED -> Value.MERCHANT_LOCKED
            SINGLE_USE -> Value.SINGLE_USE
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            VIRTUAL -> Known.VIRTUAL
            PHYSICAL -> Known.PHYSICAL
            MERCHANT_LOCKED -> Known.MERCHANT_LOCKED
            SINGLE_USE -> Known.SINGLE_USE
            else -> throw MeorphisTest6InvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = Carrier.Builder::class)
    @NoAutoDetect
    class Carrier private constructor(private val qrCodeUrl: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        /** QR code url to display on the card carrier */
        @JsonProperty("qr_code_url")
        fun qrCodeUrl(): String? = qrCodeUrl

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Carrier &&
              this.qrCodeUrl == other.qrCodeUrl &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(qrCodeUrl, additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "Carrier{qrCodeUrl=$qrCodeUrl, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var qrCodeUrl: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(carrier: Carrier) = apply {
                this.qrCodeUrl = carrier.qrCodeUrl
                additionalProperties(carrier.additionalProperties)
            }

            /** QR code url to display on the card carrier */
            @JsonProperty("qr_code_url")
            fun qrCodeUrl(qrCodeUrl: String) = apply {
                this.qrCodeUrl = qrCodeUrl
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

            fun build(): Carrier = Carrier(qrCodeUrl, additionalProperties.toUnmodifiable())
        }
    }

    @JsonDeserialize(builder = ShippingAddress.Builder::class)
    @NoAutoDetect
    class ShippingAddress private constructor(
      private val firstName: String?,
      private val lastName: String?,
      private val line2Text: String?,
      private val address1: String?,
      private val address2: String?,
      private val city: String?,
      private val state: String?,
      private val postalCode: String?,
      private val country: String?,
      private val email: String?,
      private val phoneNumber: String?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        /** Customer's first name. This will be the first name printed on the physical card. */
        @JsonProperty("first_name")
        fun firstName(): String? = firstName

        /**
         * Customer's surname (family name). This will be the last name printed on the
         * physical card.
         */
        @JsonProperty("last_name")
        fun lastName(): String? = lastName

        /**
         * Text to be printed on line two of the physical card. Use of this field requires
         * additional permissions.
         */
        @JsonProperty("line2_text")
        fun line2Text(): String? = line2Text

        /** Valid USPS routable address. */
        @JsonProperty("address1")
        fun address1(): String? = address1

        /** Unit number (if applicable). */
        @JsonProperty("address2")
        fun address2(): String? = address2

        /** City */
        @JsonProperty("city")
        fun city(): String? = city

        /**
         * Uppercase ISO 3166-2 two character abbreviation for US and CA. Optional with a
         * limit of 24 characters for other countries.
         */
        @JsonProperty("state")
        fun state(): String? = state

        /**
         * Postal code (formerly zipcode). For US addresses, either five-digit zipcode or
         * nine-digit "ZIP+4".
         */
        @JsonProperty("postal_code")
        fun postalCode(): String? = postalCode

        /** Uppercase ISO 3166-1 alpha-3 three character abbreviation. */
        @JsonProperty("country")
        fun country(): String? = country

        /**
         * Email address to be contacted for expedited shipping process purposes. Required
         * if `shipping_method` is `EXPEDITED`.
         */
        @JsonProperty("email")
        fun email(): String? = email

        /**
         * Cardholder's phone number in E.164 format to be contacted for expedited shipping
         * process purposes. Required if `shipping_method` is `EXPEDITED`.
         */
        @JsonProperty("phone_number")
        fun phoneNumber(): String? = phoneNumber

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is ShippingAddress &&
              this.firstName == other.firstName &&
              this.lastName == other.lastName &&
              this.line2Text == other.line2Text &&
              this.address1 == other.address1 &&
              this.address2 == other.address2 &&
              this.city == other.city &&
              this.state == other.state &&
              this.postalCode == other.postalCode &&
              this.country == other.country &&
              this.email == other.email &&
              this.phoneNumber == other.phoneNumber &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                firstName,
                lastName,
                line2Text,
                address1,
                address2,
                city,
                state,
                postalCode,
                country,
                email,
                phoneNumber,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "ShippingAddress{firstName=$firstName, lastName=$lastName, line2Text=$line2Text, address1=$address1, address2=$address2, city=$city, state=$state, postalCode=$postalCode, country=$country, email=$email, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var firstName: String? = null
            private var lastName: String? = null
            private var line2Text: String? = null
            private var address1: String? = null
            private var address2: String? = null
            private var city: String? = null
            private var state: String? = null
            private var postalCode: String? = null
            private var country: String? = null
            private var email: String? = null
            private var phoneNumber: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(shippingAddress: ShippingAddress) = apply {
                this.firstName = shippingAddress.firstName
                this.lastName = shippingAddress.lastName
                this.line2Text = shippingAddress.line2Text
                this.address1 = shippingAddress.address1
                this.address2 = shippingAddress.address2
                this.city = shippingAddress.city
                this.state = shippingAddress.state
                this.postalCode = shippingAddress.postalCode
                this.country = shippingAddress.country
                this.email = shippingAddress.email
                this.phoneNumber = shippingAddress.phoneNumber
                additionalProperties(shippingAddress.additionalProperties)
            }

            /** Customer's first name. This will be the first name printed on the physical card. */
            @JsonProperty("first_name")
            fun firstName(firstName: String) = apply {
                this.firstName = firstName
            }

            /**
             * Customer's surname (family name). This will be the last name printed on the
             * physical card.
             */
            @JsonProperty("last_name")
            fun lastName(lastName: String) = apply {
                this.lastName = lastName
            }

            /**
             * Text to be printed on line two of the physical card. Use of this field requires
             * additional permissions.
             */
            @JsonProperty("line2_text")
            fun line2Text(line2Text: String) = apply {
                this.line2Text = line2Text
            }

            /** Valid USPS routable address. */
            @JsonProperty("address1")
            fun address1(address1: String) = apply {
                this.address1 = address1
            }

            /** Unit number (if applicable). */
            @JsonProperty("address2")
            fun address2(address2: String) = apply {
                this.address2 = address2
            }

            /** City */
            @JsonProperty("city")
            fun city(city: String) = apply {
                this.city = city
            }

            /**
             * Uppercase ISO 3166-2 two character abbreviation for US and CA. Optional with a
             * limit of 24 characters for other countries.
             */
            @JsonProperty("state")
            fun state(state: String) = apply {
                this.state = state
            }

            /**
             * Postal code (formerly zipcode). For US addresses, either five-digit zipcode or
             * nine-digit "ZIP+4".
             */
            @JsonProperty("postal_code")
            fun postalCode(postalCode: String) = apply {
                this.postalCode = postalCode
            }

            /** Uppercase ISO 3166-1 alpha-3 three character abbreviation. */
            @JsonProperty("country")
            fun country(country: String) = apply {
                this.country = country
            }

            /**
             * Email address to be contacted for expedited shipping process purposes. Required
             * if `shipping_method` is `EXPEDITED`.
             */
            @JsonProperty("email")
            fun email(email: String) = apply {
                this.email = email
            }

            /**
             * Cardholder's phone number in E.164 format to be contacted for expedited shipping
             * process purposes. Required if `shipping_method` is `EXPEDITED`.
             */
            @JsonProperty("phone_number")
            fun phoneNumber(phoneNumber: String) = apply {
                this.phoneNumber = phoneNumber
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

            fun build(): ShippingAddress = ShippingAddress(
                checkNotNull(firstName) {
                    "`firstName` is required but was not set"
                },
                checkNotNull(lastName) {
                    "`lastName` is required but was not set"
                },
                line2Text,
                checkNotNull(address1) {
                    "`address1` is required but was not set"
                },
                address2,
                checkNotNull(city) {
                    "`city` is required but was not set"
                },
                checkNotNull(state) {
                    "`state` is required but was not set"
                },
                checkNotNull(postalCode) {
                    "`postalCode` is required but was not set"
                },
                checkNotNull(country) {
                    "`country` is required but was not set"
                },
                email,
                phoneNumber,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    class ShippingMethod @JsonCreator private constructor(private val value: JsonField<String>, ) {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is ShippingMethod &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STANDARD = ShippingMethod(JsonField.of("STANDARD"))

            @JvmField val STANDARD_WITH_TRACKING = ShippingMethod(JsonField.of("STANDARD_WITH_TRACKING"))

            @JvmField val PRIORITY = ShippingMethod(JsonField.of("PRIORITY"))

            @JvmField val EXPRESS = ShippingMethod(JsonField.of("EXPRESS"))

            @JvmField val _2_DAY = ShippingMethod(JsonField.of("2_DAY"))

            @JvmField val EXPEDITED = ShippingMethod(JsonField.of("EXPEDITED"))

            @JvmStatic fun of(value: String) = ShippingMethod(JsonField.of(value))
        }

        enum class Known {
            STANDARD,
            STANDARD_WITH_TRACKING,
            PRIORITY,
            EXPRESS,
            _2_DAY,
            EXPEDITED,
        }

        enum class Value {
            STANDARD,
            STANDARD_WITH_TRACKING,
            PRIORITY,
            EXPRESS,
            _2_DAY,
            EXPEDITED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            STANDARD -> Value.STANDARD
            STANDARD_WITH_TRACKING -> Value.STANDARD_WITH_TRACKING
            PRIORITY -> Value.PRIORITY
            EXPRESS -> Value.EXPRESS
            _2_DAY -> Value._2_DAY
            EXPEDITED -> Value.EXPEDITED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            STANDARD -> Known.STANDARD
            STANDARD_WITH_TRACKING -> Known.STANDARD_WITH_TRACKING
            PRIORITY -> Known.PRIORITY
            EXPRESS -> Known.EXPRESS
            _2_DAY -> Known._2_DAY
            EXPEDITED -> Known.EXPEDITED
            else -> throw MeorphisTest6InvalidDataException("Unknown ShippingMethod: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    class SpendLimitDuration @JsonCreator private constructor(private val value: JsonField<String>, ) {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is SpendLimitDuration &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val ANNUALLY = SpendLimitDuration(JsonField.of("ANNUALLY"))

            @JvmField val FOREVER = SpendLimitDuration(JsonField.of("FOREVER"))

            @JvmField val MONTHLY = SpendLimitDuration(JsonField.of("MONTHLY"))

            @JvmField val TRANSACTION = SpendLimitDuration(JsonField.of("TRANSACTION"))

            @JvmStatic fun of(value: String) = SpendLimitDuration(JsonField.of(value))
        }

        enum class Known {
            ANNUALLY,
            FOREVER,
            MONTHLY,
            TRANSACTION,
        }

        enum class Value {
            ANNUALLY,
            FOREVER,
            MONTHLY,
            TRANSACTION,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ANNUALLY -> Value.ANNUALLY
            FOREVER -> Value.FOREVER
            MONTHLY -> Value.MONTHLY
            TRANSACTION -> Value.TRANSACTION
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ANNUALLY -> Known.ANNUALLY
            FOREVER -> Known.FOREVER
            MONTHLY -> Known.MONTHLY
            TRANSACTION -> Known.TRANSACTION
            else -> throw MeorphisTest6InvalidDataException("Unknown SpendLimitDuration: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    class State @JsonCreator private constructor(private val value: JsonField<String>, ) {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is State &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OPEN = State(JsonField.of("OPEN"))

            @JvmField val PAUSED = State(JsonField.of("PAUSED"))

            @JvmStatic fun of(value: String) = State(JsonField.of(value))
        }

        enum class Known {
            OPEN,
            PAUSED,
        }

        enum class Value {
            OPEN,
            PAUSED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            OPEN -> Value.OPEN
            PAUSED -> Value.PAUSED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            OPEN -> Known.OPEN
            PAUSED -> Known.PAUSED
            else -> throw MeorphisTest6InvalidDataException("Unknown State: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
