package com.dapadz.mjpegplayer.media_source.mjpeg_stream.connector

import io.ktor.http.HttpStatusCode

interface StreamConnectorListener {
    fun onStart()
    fun onStop()
    fun onFirstLoaded()
    fun onError(code: HttpStatusCode)
}