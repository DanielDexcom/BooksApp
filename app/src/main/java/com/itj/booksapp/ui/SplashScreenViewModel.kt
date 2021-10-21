package com.itj.booksapp.ui

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashScreenViewModel : ViewModel() {

    private val _openMainActivity = MutableLiveData(false)
    val openMainActivity: LiveData<Boolean> = _openMainActivity

    fun load() {
        Handler().postDelayed({
            _openMainActivity.value = true
        }, 3000)
    }

}