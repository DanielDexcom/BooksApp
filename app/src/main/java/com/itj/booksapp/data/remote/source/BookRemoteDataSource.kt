package com.itj.booksapp.data.remote.source

import com.itj.booksapp.data.remote.model.AuthorEntry
import com.itj.booksapp.data.remote.model.BookDetailEntry
import com.itj.booksapp.data.remote.net.BookRemoteApi
import com.itj.booksapp.data.repository.SearchRepository
import com.itj.booksapp.domain.model.Book
import retrofit2.await

class BookRemoteDataSource (private val bookRemoteApi: BookRemoteApi): SearchRepository {

    override suspend fun search(isbn: String): Book? {
        val bookEntry = bookRemoteApi.getBookByIsbn(isbn).await()
        val bookDescription = getBookDetail(bookEntry.works[0].key)
        val bookAuthor = getBookAuthor(bookEntry.authors[0].key)

        return Book(
            isbn = bookEntry.isbn13[0],
            title = bookEntry.title,
            description = bookDescription.description,
            author = bookAuthor.name,
            publishedDate = bookEntry.publishDate,
            pages = bookEntry.numberOfPages,
            publisher = bookEntry.publishers[0],
            url = null,
            image = "https://covers.openlibrary.org/b/id/${bookEntry.covers[0]}-L.jpg"
        )

    }

    suspend fun getBookDetail(key: String): BookDetailEntry {
        return bookRemoteApi.getBookDetails(key).await()
    }

    suspend fun getBookAuthor(key: String): AuthorEntry {
        return bookRemoteApi.getBookAuthor(key).await()
    }
}


