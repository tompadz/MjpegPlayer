package com.dapadz.mjpegplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dapadz.mjpegplayer.frame_processor.DefaultFrameProcessor
import com.dapadz.mjpegplayer.media_source.MediaSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

