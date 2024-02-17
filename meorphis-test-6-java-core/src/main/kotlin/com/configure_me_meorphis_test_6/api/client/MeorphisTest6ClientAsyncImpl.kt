// File generated from our OpenAPI spec by Stainless.

package com.configure_me_meorphis_test_6.api.client

import java.time.Duration
import java.util.Base64
import java.util.Optional
import java.util.concurrent.CompletableFuture
import com.configure_me_meorphis_test_6.api.core.ClientOptions
import com.configure_me_meorphis_test_6.api.core.http.HttpMethod
import com.configure_me_meorphis_test_6.api.core.http.HttpRequest
import com.configure_me_meorphis_test_6.api.core.http.HttpResponse.Handler
import com.configure_me_meorphis_test_6.api.core.JsonField
import com.configure_me_meorphis_test_6.api.core.RequestOptions
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6Error
import com.configure_me_meorphis_test_6.api.errors.MeorphisTest6InvalidDataException
import com.configure_me_meorphis_test_6.api.models.*
import com.configure_me_meorphis_test_6.api.services.async.*
import com.configure_me_meorphis_test_6.api.services.emptyHandler
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.json
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.stringHandler
import com.configure_me_meorphis_test_6.api.services.binaryHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler

class MeorphisTest6ClientAsyncImpl constructor(private val clientOptions: ClientOptions, ) : MeorphisTest6ClientAsync {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val sync: MeorphisTest6Client by lazy { MeorphisTest6ClientImpl(clientOptions) }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val cards: CardServiceAsync by lazy { CardServiceAsyncImpl(clientOptions) }

    private val statuses: StatusServiceAsync by lazy { StatusServiceAsyncImpl(clientOptions) }

    override fun sync(): MeorphisTest6Client = sync

    override fun accounts(): AccountServiceAsync = accounts

    override fun cards(): CardServiceAsync = cards

    override fun statuses(): StatusServiceAsync = statuses
}
