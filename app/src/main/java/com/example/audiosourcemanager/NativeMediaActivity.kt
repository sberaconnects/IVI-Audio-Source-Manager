package com.example.audiosourcemanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer

class NativeMediaActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var focusManager: AudioFocusManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        focusManager = AudioFocusManager(this) { focusChange ->
            when (focusChange) {
                android.media.AudioManager.AUDIOFOCUS_LOSS -> stopPlayback()
                android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> mediaPlayer?.pause()
                android.media.AudioManager.AUDIOFOCUS_GAIN -> mediaPlayer?.start()
            }
        }

        if (focusManager.requestFocus()) {
            playNativeAudio()
        } else {
            Toast.makeText(this, "Audio Focus Denied", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun playNativeAudio() {
        mediaPlayer = MediaPlayer()
        val afd = assets.openFd("sample.mp3")
        mediaPlayer?.apply {
            setAudioAttributes(
                android.media.AudioAttributes.Builder()
                    .setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            prepare()
            start()
        }
    }

    private fun stopPlayback() {
        mediaPlayer?.release()
        mediaPlayer = null
        finish()
    }

    override fun onStop() {
        super.onStop()
        stopPlayback()
        focusManager.abandonFocus()
    }
}
