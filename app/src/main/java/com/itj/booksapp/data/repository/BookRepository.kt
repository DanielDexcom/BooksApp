package com.itj.booksapp.data.repository

import com.itj.booksapp.data.remote.model.AuthorEntry
import com.itj.booksapp.data.remote.model.book.BookDetailEntry
import com.itj.booksapp.data.remote.model.book.BookEntry
import com.itj.booksapp.data.remote.source.BookRemoteDataSource

class BookRepository(
    private val bookRemoteDataSource: BookRemoteDataSource
    // TODO Add localDataSource for wish list
) {
    suspend fun getBookByIsbnId(isbn: String): BookEntry {
        return bookRemoteDataSource.getBookByISBN(isbn)
    }

    suspend fun getBookDetails(key: String): BookDetailEntry {
        return bookRemoteDataSource.getBookDetails(key)
    }

    suspend fun getBookAuthor(key: String): AuthorEntry {
        return bookRemoteDataSource.getBookAuthor(key)
    }

    // TODO ADD SAVE BOOK TO WISH LIST AND DELETE BOOK (with localDataSource)
}