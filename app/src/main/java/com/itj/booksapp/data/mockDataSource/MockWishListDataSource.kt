package com.itj.booksapp.data.mockDataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.data.repository.WishListRepository

class MockWishListDataSource: WishListRepository {

    private val books = MutableLiveData(listOf(Book(
        "123456789",
        "Title 3",
        "Description 3",
        "Author 3",
        "https://www.link.com",
        "Publisher 3",
        "May 13th 1997",
        250,
        "none"
    ), Book(
        "1234567810",
        "Title 4",
        "Description 4",
        "Author 4",
        "https://www.link.com",
        "Publisher 4",
        "Jun 14 1998",
        300,
        "none"
    )))

    override fun getAll(): LiveData<List<Book>> {
        return books
    }

    override fun add(book: Book) {
        // Todo Add to the list
    }

    override fun remove(book: Book): Boolean {
        val initialBooks = books.value ?: return false
        val newBooks = books.value?.let { books->
            books.filterNot { it.isbn == book.isbn }
        }
        if (newBooks != null) {
            return if (newBooks.size == initialBooks.size) {
                // The ISBN provided was not in the books list. No book was deleted
                false
            } else {
                // A book was deleted. Update live data
                books.value = newBooks
                true
            }
        } else {
            return if (initialBooks.isEmpty()) {
                // initialBooks was empty. No book was deleted
                false
            } else {
                // Last book of initialBooks was deleted. Update live data
                books.value = newBooks
                true
            }
        }
    }
}