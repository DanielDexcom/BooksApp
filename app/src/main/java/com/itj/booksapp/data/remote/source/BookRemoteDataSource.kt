package com.itj.booksapp.data.remote.source

import com.itj.booksapp.data.remote.model.AuthorEntry
import com.itj.booksapp.data.remote.model.book.BookDetailEntry
import com.itj.booksapp.data.remote.model.book.BookEntry
import com.itj.booksapp.data.remote.net.BookRemoteApi
import retrofit2.await

class BookRemoteDataSource() : BaseRemoteDataSoure() {
    private val service: BookRemoteApi = retrofit.create(BookRemoteApi::class.java)

    suspend fun getBookByISBN(isbn: String): BookEntry {
        return service.getBookByISBN(isbn).await()
    }

    suspend fun getBookDetails(key: String): BookDetailEntry {
        return service.getBookDetails(key).await()
    }

    suspend fun getBookAuthor(key: String): AuthorEntry {
        return service.getBookAuthor(key).await()
    }
}