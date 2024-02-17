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
import com.configure_me_meorphis_test_6.api.core.JsonMissing
import com.configure_me_meorphis_test_6.api.core.JsonValue
import com.configure_me_meorphis_test_6.api.core.JsonField
import com.configure_me_meorphis_test_6.api.core.toUnmodifiable
import com.configure_me_meorphis_test_6.api.core.NoAutoDetect
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6InvalidDataException

@JsonDeserialize(builder = StatusGetStatusResponse.Builder::class)
@NoAutoDetect
class StatusGetStatusResponse private constructor(private val message: JsonField<String>, private val additionalProperties: Map<String, JsonValue>, ) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun message(): Optional<String> = Optional.ofNullable(message.getNullable("message"))

    @JsonProperty("message")
    @ExcludeMissing
    fun _message() = message

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): StatusGetStatusResponse = apply {
        if (!validated) {
          message()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is StatusGetStatusResponse &&
          this.message == other.message &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(message, additionalProperties)
      }
      return hashCode
    }

    override fun toString() = "StatusGetStatusResponse{message=$message, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {

        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(statusGetStatusResponse: StatusGetStatusResponse) = apply {
            this.message = statusGetStatusResponse.message
            additionalProperties(statusGetStatusResponse.additionalProperties)
        }

        fun message(message: String) = message(JsonField.of(message))

        @JsonProperty("message")
        @ExcludeMissing
        fun message(message: JsonField<String>) = apply {
            this.message = message
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

        fun build(): StatusGetStatusResponse = StatusGetStatusResponse(message, additionalProperties.toUnmodifiable())
    }
}
