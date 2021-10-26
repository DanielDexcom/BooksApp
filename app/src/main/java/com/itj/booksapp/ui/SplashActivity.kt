package com.itj.booksapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itj.booksapp.MainActivity
import com.itj.booksapp.R

class SplashActivity : AppCompatActivity() {

    private val viewModel = SplashScreenViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.openMainActivity.observe(this) { openMainScreen ->
            if (openMainScreen) {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
            }
        }

        viewModel.load()
    }
}