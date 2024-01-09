package com.dapadz.mjpegplayer.media_source.rtsp_stream

import com.dapadz.mjpegplayer.frame_processor.DefaultFrameProcessor
import com.dapadz.mjpegplayer.media_source.MediaSource
import com.dapadz.mjpegplayer.media_source.MediaSourceFrameListener

class RtspStreamMediaSource(rtspUrl: String): MediaSource<DefaultFrameProcessor> {

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