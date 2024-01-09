package com.dapadz.mjpegplayer.media_source

import com.dapadz.mjpegplayer.frame_processor.FrameProcessor

interface MediaSource<P : FrameProcessor> {

    val processor: P

    fun start()

    fun stop()

    fun addSourceListener(listener : MediaSourceFrameListener?)
}