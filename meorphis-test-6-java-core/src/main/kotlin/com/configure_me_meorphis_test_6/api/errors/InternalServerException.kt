package com.configure_me_meorphis_test_6.api.errors

import com.google.common.collect.ListMultimap

class InternalServerException
constructor(
        private val statusCode: Int,
        headers: ListMultimap<String, String>,
        private val error: MeorphisTest6Error,
) : MeorphisTest6ServiceException(headers, "${error}") {
    override fun statusCode(): Int = statusCode
    fun error(): MeorphisTest6Error = error
}
