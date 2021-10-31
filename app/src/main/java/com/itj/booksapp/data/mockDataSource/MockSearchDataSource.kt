package com.itj.booksapp.data.mockDataSource

import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.SearchRepository

class MockSearchDataSource: SearchRepository {
    override fun search(isbn: String): Book {
        return Book(
            isbn,
            "Title from search",
            "Description from search",
            "Author from search",
            "https://www.search.com",
            "Publisher from search",
            "Two days ago",
            300,
            "none"
        )
    }
}