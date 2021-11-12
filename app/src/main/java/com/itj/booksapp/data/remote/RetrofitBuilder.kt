package com.itj.booksapp.data.remote

import androidx.viewbinding.BuildConfig
import com.itj.booksapp.data.remote.net.BookRemoteApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://openlibrary.org/"

    private fun getRetrofit() : Retrofit {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            retrofitBuilder.client(client)
        }

        return retrofitBuilder.build()

    }

    val bookRemoteApi: BookRemoteApi = getRetrofit().create(BookRemoteApi::class.java)

}