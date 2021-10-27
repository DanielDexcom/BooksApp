package com.itj.booksapp.data.remote.net;

import com.itj.booksapp.data.Book;
import com.itj.booksapp.data.remote.model.AuthorEntry
import com.itj.booksapp.data.remote.model.book.BookDetailEntry
import com.itj.booksapp.data.remote.model.book.BookEntry

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookRemoteApi {

    @GET("isbn/{ISBNId}.json")
    fun getBookByISBN(
        @Path("ISBNId") isbnId: String
    ): Call<BookEntry>

    @GET("{key}.json")
    fun getBookDetails(
        @Path("key") workId: String
    ): Call<BookDetailEntry>

    @GET("{key}.json")
    fun getBookAuthor(
        @Path("key") workId: String
    ): Call<AuthorEntry>

}
