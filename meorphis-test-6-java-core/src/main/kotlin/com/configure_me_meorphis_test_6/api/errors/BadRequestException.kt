package com.configure_me_meorphis_test_6.api.errors

import com.google.common.collect.ListMultimap

class BadRequestException
constructor(
    headers: ListMultimap<String, String>,
    private val error: MeorphisTest6Error,
) : MeorphisTest6ServiceException(headers, "${error}") {
    override fun statusCode(): Int = 400
    fun error(): MeorphisTest6Error = error
}
