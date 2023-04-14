package com.example.myuccapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Welcome_Scrn : AppCompatActivity() {

    private val Splash_Time: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen)

        Handler().postDelayed( {
            startActivity(Intent (this, MainActivity::class.java))
            finish()
        }, Splash_Time)
    }
}