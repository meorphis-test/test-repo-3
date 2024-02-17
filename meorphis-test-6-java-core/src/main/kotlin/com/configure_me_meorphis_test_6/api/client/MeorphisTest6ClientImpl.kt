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
import com.configure_me_meorphis_test_6.api.services.blocking.*
import com.configure_me_meorphis_test_6.api.services.emptyHandler
import com.configure_me_meorphis_test_6.api.services.errorHandler
import com.configure_me_meorphis_test_6.api.services.json
import com.configure_me_meorphis_test_6.api.services.jsonHandler
import com.configure_me_meorphis_test_6.api.services.stringHandler
import com.configure_me_meorphis_test_6.api.services.binaryHandler
import com.configure_me_meorphis_test_6.api.services.withErrorHandler

class MeorphisTest6ClientImpl constructor(private val clientOptions: ClientOptions, ) : MeorphisTest6Client {

    private val errorHandler: Handler<MeorphisTest6Error> = errorHandler(clientOptions.jsonMapper)

    private val async: MeorphisTest6ClientAsync by lazy { MeorphisTest6ClientAsyncImpl(clientOptions) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val cards: CardService by lazy { CardServiceImpl(clientOptions) }

    private val statuses: StatusService by lazy { StatusServiceImpl(clientOptions) }

    override fun async(): MeorphisTest6ClientAsync = async

    override fun accounts(): AccountService = accounts

    override fun cards(): CardService = cards

    override fun statuses(): StatusService = statuses
}
