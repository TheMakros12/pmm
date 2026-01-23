package com.example.barralateral.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.barralateral.R
import com.example.barralateral.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash)

        binding.lottieView.playAnimation()

        val splashScreenDuration = 3000 // 3 segundos
        val intent = Intent(this, MainActivity::class.java)

        binding.lottieView.postDelayed({
            startActivity(intent)
            finish()
        }, splashScreenDuration.toLong())

    }
}