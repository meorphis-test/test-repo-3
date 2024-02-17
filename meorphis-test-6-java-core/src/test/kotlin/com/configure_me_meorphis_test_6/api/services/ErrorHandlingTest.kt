// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.services

import com.configure_me_meorphis_test_6.api.client.MeorphisTest6Client
import com.configure_me_meorphis_test_6.api.client.okhttp.MeorphisTest6OkHttpClient
import com.configure_me_meorphis_test_6.api.core.JsonString
import com.configure_me_meorphis_test_6.api.core.jsonMapper
import com.configure_me_meorphis_test_6.api.errors.BadRequestException
import com.configure_me_meorphis_test_6.api.errors.InternalServerException
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Exception
import com.configure_me_meorphis_test_6.api.errors.NotFoundException
import com.configure_me_meorphis_test_6.api.errors.PermissionDeniedException
import com.configure_me_meorphis_test_6.api.errors.RateLimitException
import com.configure_me_meorphis_test_6.api.errors.UnauthorizedException
import com.configure_me_meorphis_test_6.api.errors.UnexpectedStatusCodeException
import com.configure_me_meorphis_test_6.api.errors.UnprocessableEntityException
import com.configure_me_meorphis_test_6.api.models.*
import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val MEORPHIS_TEST6_ERROR: MeorphisTest6Error =
        MeorphisTest6Error.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: MeorphisTest6Client

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            MeorphisTest6OkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun accountsRetrieve200() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val expected =
            AccountRetrieveResponse.builder()
                .token("b68b7424-aa69-4cbc-a946-30d90181b621")
                .spendLimit(
                    AccountRetrieveResponse.SpendLimit.builder()
                        .daily(123L)
                        .lifetime(123L)
                        .monthly(123L)
                        .build()
                )
                .state(AccountRetrieveResponse.State.ACTIVE)
                .accountHolder(
                    AccountRetrieveResponse.AccountHolder.builder()
                        .token("95e5f1b7-cfd5-4520-aa3c-2451bab8608d")
                        .businessAccountToken("e87db14a-4abf-4901-adad-5d5c9f46aff2")
                        .email("jack@acme.com")
                        .phoneNumber("+12124007676")
                        .build()
                )
                .authRuleTokens(listOf("string"))
                .verificationAddress(
                    AccountRetrieveResponse.VerificationAddress.builder()
                        .address1("124 Old Forest Way")
                        .city("Seattle")
                        .country("USA")
                        .postalCode("98109")
                        .state("WA")
                        .address2("Apt 21")
                        .build()
                )
                .build()

        stubFor(get(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.accounts().retrieve(params)).isEqualTo(expected)
    }

    @Test
    fun accountsRetrieve400() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), MEORPHIS_TEST6_ERROR)
            })
    }

    @Test
    fun accountsRetrieve401() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), MEORPHIS_TEST6_ERROR)
            })
    }

    @Test
    fun accountsRetrieve403() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertPermissionDenied(
                    e,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    MEORPHIS_TEST6_ERROR
                )
            })
    }

    @Test
    fun accountsRetrieve404() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), MEORPHIS_TEST6_ERROR)
            })
    }

    @Test
    fun accountsRetrieve422() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    MEORPHIS_TEST6_ERROR
                )
            })
    }

    @Test
    fun accountsRetrieve429() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), MEORPHIS_TEST6_ERROR)
            })
    }

    @Test
    fun accountsRetrieve500() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertInternalServer(
                    e,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    MEORPHIS_TEST6_ERROR
                )
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader("Foo", "Bar").withBody(toJson(MEORPHIS_TEST6_ERROR))
                )
        )

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    toJson(MEORPHIS_TEST6_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(get(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(MeorphisTest6Exception::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            AccountRetrieveParams.builder()
                .accountToken("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        stubFor(get(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.accounts().retrieve(params) })
            .satisfies({ e ->
                assertBadRequest(
                    e,
                    ImmutableListMultimap.of(),
                    MeorphisTest6Error.builder().build()
                )
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: ListMultimap<String, String>,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertBadRequest(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertNotFound(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertRateLimit(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MeorphisTest6Error
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }
}
