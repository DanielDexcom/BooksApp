package com.itj.booksapp.data.remote.net

import com.itj.booksapp.data.remote.model.AuthorEntry
import com.itj.booksapp.data.remote.model.BookDetailEntry
import com.itj.booksapp.data.remote.model.BookEntry
import retrofit2.Call
import retrofit2.http.*

interface BookRemoteApi {

    @GET("isbn/{isbn}.json")
    fun getBookByIsbn(@Path("isbn") isbn: String): Call<BookEntry>

    @GET("{key}.json")
    fun getBookDetails(@Path("key") key: String): Call<BookDetailEntry>

    @GET("{key}.json")
    fun getBookAuthor(@Path("key") key: String): Call<AuthorEntry>

    /*@Header("Accept: application/json")
    @POST("somePostUrl")
    fun saveBook(@Body book: BookEntry): Call<ResponseBook>


    @FormUrlEncoded
    @POST("posturl")
    fun saveBook(@Field bookId: String),.....*/
}