package com.dapadz.mjpegplayer.media_source.mjpeg_stream.connector

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.prepareGet
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.isEmpty
import io.ktor.utils.io.core.readBytes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class StreamConnector(private val url : String) : CoroutineScope {

    private var client : HttpClient? = null
    private var listener : StreamConnectorListener? = null
    private var isLoadedBefore = false

    fun start() {
        client = createHttpClient()
        listener?.onStart()
        startConnection()
    }

    fun stop() {
        client?.close()
        listener?.onStop()
    }

    private fun startConnection() {
        launchFrameCapture {
            processBytes(it) {

            }
        }
    }

    private fun launchFrameCapture(block : suspend (ByteReadChannel) -> Unit) = launch {
        if (client == null || client?.isActive == true) return@launch
        client !!.prepareGet(url).execute { httpResponse ->
            checkStatus(httpResponse.status)
            val channel : ByteReadChannel = httpResponse.body()
            block(channel)
        }
    }

    private suspend fun processBytes(channel: ByteReadChannel, block: suspend (ByteArray) -> Unit) {
        while (!channel.isClosedForRead) {
            val packet = channel.readRemaining(DEFAULT_BUFFER_SIZE.toLong())
            while (!packet.isEmpty) {
                val bytes = packet.readBytes()
                block(bytes)
            }
        }
    }

    private fun checkStatus(statusCode : HttpStatusCode) {
        if (statusCode.isSuccess()) {
            if (! isLoadedBefore) {
                listener?.onFirstLoaded()
            }
        } else {
            listener?.onError(statusCode)
        }
    }

    private fun createHttpClient() : HttpClient {
        return HttpClient(CIO) {
            engine {
                requestTimeout = 0
            }
        }
    }

    override val coroutineContext : CoroutineContext = SupervisorJob() + Dispatchers.IO

}