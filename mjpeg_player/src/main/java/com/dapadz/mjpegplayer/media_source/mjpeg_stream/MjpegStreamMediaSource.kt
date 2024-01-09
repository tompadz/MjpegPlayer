package com.dapadz.mjpegplayer.media_source.mjpeg_stream

import com.dapadz.mjpegplayer.frame_processor.DefaultFrameProcessor
import com.dapadz.mjpegplayer.media_source.MediaSource
import com.dapadz.mjpegplayer.media_source.MediaSourceFrameListener

open class MjpegStreamMediaSource(streamUrl: String) : MediaSource<DefaultFrameProcessor> {

    override val processor = DefaultFrameProcessor()

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun addSourceListener(listener : MediaSourceFrameListener?) {
        TODO("Not yet implemented")
    }

}