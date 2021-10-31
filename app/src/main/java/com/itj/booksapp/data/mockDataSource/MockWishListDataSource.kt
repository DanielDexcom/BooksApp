package com.itj.booksapp.data.mockDataSource

import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.WishListRepository

class MockWishListDataSource: WishListRepository {
    private val books: MutableList<Book> = mutableListOf(Book(
        "123456789",
        "Title 3",
        "Description 3",
        "Author 3",
        "https://www.link.com",
        "Publisher 3",
        "Today",
        250,
        "none"
    ), Book(
        "123456789",
        "Title 4",
        "Description 4",
        "Author 4",
        "https://www.link.com",
        "Publisher 4",
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