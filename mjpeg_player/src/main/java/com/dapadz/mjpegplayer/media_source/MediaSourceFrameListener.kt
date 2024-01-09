package com.dapadz.mjpegplayer.media_source

import Frame

fun interface MediaSourceFrameListener {
    fun onFrameReady(frame : Frame)
}