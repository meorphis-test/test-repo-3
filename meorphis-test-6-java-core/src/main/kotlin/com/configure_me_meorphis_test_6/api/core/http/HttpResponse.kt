package com.configure_me_meorphis_test_6.api.core.http

import com.google.common.collect.ListMultimap
import java.io.Closeable
import java.io.InputStream

interface HttpResponse : Closeable {

    fun statusCode(): Int

    fun headers(): ListMultimap<String, String>

    fun body(): InputStream

    interface Handler<T> {

        fun handle(response: HttpResponse): T
    }
}
