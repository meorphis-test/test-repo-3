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

@JsonDeserialize(builder = CardProvisionPostProvisionResponse.Builder::class)
@NoAutoDetect
class CardProvisionPostProvisionResponse
private constructor(
    private val provisioningPayload: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun provisioningPayload(): Optional<String> =
        Optional.ofNullable(provisioningPayload.getNullable("provisioning_payload"))

    @JsonProperty("provisioning_payload")
    @ExcludeMissing
    fun _provisioningPayload() = provisioningPayload

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CardProvisionPostProvisionResponse = apply {
        if (!validated) {
            provisioningPayload()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CardProvisionPostProvisionResponse &&
            this.provisioningPayload == other.provisioningPayload &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(provisioningPayload, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "CardProvisionPostProvisionResponse{provisioningPayload=$provisioningPayload, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var provisioningPayload: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(cardProvisionPostProvisionResponse: CardProvisionPostProvisionResponse) =
            apply {
                this.provisioningPayload = cardProvisionPostProvisionResponse.provisioningPayload
                additionalProperties(cardProvisionPostProvisionResponse.additionalProperties)
            }

        fun provisioningPayload(provisioningPayload: String) =
            provisioningPayload(JsonField.of(provisioningPayload))

        @JsonProperty("provisioning_payload")
        @ExcludeMissing
        fun provisioningPayload(provisioningPayload: JsonField<String>) = apply {
            this.provisioningPayload = provisioningPayload
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

        fun build(): CardProvisionPostProvisionResponse =
            CardProvisionPostProvisionResponse(
                provisioningPayload,
                additionalProperties.toUnmodifiable()
            )
    }
}
