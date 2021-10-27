package com.itj.booksapp.ui

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashScreenViewModel : ViewModel() {

    private val _openMainActivity = MutableLiveData(false)
    val openMainActivity: LiveData<Boolean> = _openMainActivity

    fun load() {
        // This will be replaced with any real work that needs to be done when the app launches
        Handler().postDelayed({
            _openMainActivity.value = true
        }, 3000)
    }



}