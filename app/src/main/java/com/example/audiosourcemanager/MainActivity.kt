package com.example.audiosourcemanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnNative).setOnClickListener {
            startActivity(Intent(this, NativeMediaActivity::class.java))
        }

        findViewById<Button>(R.id.btnBrowser).setOnClickListener {
            startActivity(Intent(this, BrowserMediaActivity::class.java))
        }

        findViewById<Button>(R.id.btnUSB).setOnClickListener {
            startActivity(Intent(this, UsbMediaActivity::class.java))
        }
    }
}
