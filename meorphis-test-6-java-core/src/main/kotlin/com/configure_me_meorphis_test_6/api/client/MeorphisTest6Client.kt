// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.configure_me_meorphis_test_6.api.client

import com.configure_me_meorphis_test_6.api.models.*
import com.configure_me_meorphis_test_6.api.services.blocking.*

interface MeorphisTest6Client {

    fun async(): MeorphisTest6ClientAsync

    fun accounts(): AccountService

    fun cards(): CardService

    fun statuses(): StatusService
}
