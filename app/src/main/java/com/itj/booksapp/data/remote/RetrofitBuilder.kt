package com.itj.booksapp.data.remote

import com.itj.booksapp.data.remote.net.BookRemoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://openlibrary.org/"

    private fun getRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val bookRemoteApi: BookRemoteApi = getRetrofit().create(BookRemoteApi::class.java)

}