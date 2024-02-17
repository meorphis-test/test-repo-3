package com.configure_me_meorphis_test_6.api.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException
constructor(
        headers: ListMultimap<String, String>,
        private val error: MeorphisTest6Error,
) : MeorphisTest6ServiceException(headers, "${error}") {
    override fun statusCode(): Int = 401
    fun error(): MeorphisTest6Error = error
}
