package com.configure_me_meorphis_test_6.api.errors

import com.google.common.collect.ListMultimap

abstract class MeorphisTest6ServiceException
@JvmOverloads
constructor(
    private val headers: ListMultimap<String, String>,
    message: String? = null,
    cause: Throwable? = null
) : MeorphisTest6Exception(message, cause) {
    abstract fun statusCode(): Int
    fun headers(): ListMultimap<String, String> = headers
}
