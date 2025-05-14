package com.example.audiosourcemanager

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer

class UsbMediaActivity : AppCompatActivity() {

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
            playUsbAudio()
        } else {
            Toast.makeText(this, "Audio Focus Denied", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun playUsbAudio() {
        mediaPlayer = MediaPlayer()
        try {
            // Simulate USB media by playing a local file from internal storage
            val filePath = "/storage/emulated/0/Music/sample_usb.mp3"
            val uri = Uri.parse("file://$filePath")
            mediaPlayer?.apply {
                setDataSource(this@UsbMediaActivity, uri)
                setAudioAttributes(
                    android.media.AudioAttributes.Builder()
                        .setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                prepare()
                start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error playing USB media", Toast.LENGTH_SHORT).show()
            finish()
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
