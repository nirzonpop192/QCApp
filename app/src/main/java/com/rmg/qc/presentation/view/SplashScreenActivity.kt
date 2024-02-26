package com.foodibd.rider.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import java.util.Timer
import java.util.TimerTask

class SplashScreenActivity : AppCompatActivity() {


    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            timer.cancel()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }
        }, 2000, 2000)
    }
}