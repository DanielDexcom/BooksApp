package com.itj.booksapp.data.remote.source

import com.itj.booksapp.data.remote.net.DataConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRemoteDataSoure {

    var retrofit: Retrofit

    init {
        val baseUrl = DataConstants.URL_BASE
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}