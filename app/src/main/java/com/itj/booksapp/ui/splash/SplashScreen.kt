package com.itj.booksapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.MainActivity
import com.itj.booksapp.R

class SplashScreen : AppCompatActivity() {

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val factory = SplashScreenViewModel.SplashScreenFactory()
        viewModel = ViewModelProvider(this, factory).get(SplashScreenViewModel::class.java)

        viewModel.shouldStartMainScreen.observe(this) { shouldStart ->
            if (shouldStart) {
                startMainActivity()
            }
        }

    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}