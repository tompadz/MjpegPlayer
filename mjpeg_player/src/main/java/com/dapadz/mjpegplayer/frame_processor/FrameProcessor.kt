package com.dapadz.mjpegplayer.frame_processor

import Frame

interface FrameProcessor {

    fun processFrame(frameData: ByteArray): Frame
}