package com.configure_me_meorphis_test_6.api.core.http

import com.google.common.collect.ListMultimap
import java.io.Closeable
import java.io.InputStream
import java.io.IOException
import java.io.OutputStream

interface BinaryResponseContent : Closeable {

    fun contentType(): String?

    fun body(): InputStream

    @Throws(IOException::class) fun writeTo(outputStream: OutputStream)
}