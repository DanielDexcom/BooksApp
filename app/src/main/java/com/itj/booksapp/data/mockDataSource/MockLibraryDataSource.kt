package com.itj.booksapp.data.mockDataSource

import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.LibraryRepository

class MockLibraryDataSource: LibraryRepository {
    private val books: MutableList<Book> = mutableListOf(Book(
        "123456789",
        "Title 1",
        "Description 1",
        "Author 1",
        "https://www.link.com",
        "Publisher 1",
        "Today",
        250,
        "none"
    ), Book(
        "123456789",
        "Title 2",
        "Description 2",
        "Author 2",
        "https://www.link.com",
        "Publisher 2",
        "Yesterday",
        300,
        "none"
    ))

    override fun getAll(): List<Book> {
        return books
    }

    override fun add(book: Book) {
        books.add(book)
    }
}