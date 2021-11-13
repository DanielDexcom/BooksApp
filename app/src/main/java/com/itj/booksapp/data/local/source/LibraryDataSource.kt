package com.itj.booksapp.data.local.source

import com.itj.booksapp.data.local.database.BookDao
import com.itj.booksapp.data.local.model.toBook
import com.itj.booksapp.data.repository.LibraryRepository
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.domain.model.toEntity

class LibraryDataSource(
    private val bookDao: BookDao
) : LibraryRepository {

    suspend override fun getAll(): List<Book> {
        return bookDao.getBooksFromLibrary().map { it.toBook() }
    }

    suspend override fun add(book: Book) {
        bookDao.save(book.toEntity())
    }
}