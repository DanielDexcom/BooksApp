package com.itj.booksapp.mockData.dataSource

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itj.booksapp.data.bookList
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.BookRepository

class MockBookDataSource(resources: Resources) : BookRepository {
    private var initialBookList = bookList(resources)
    private val bookLiveData = MutableLiveData(initialBookList)

    override suspend fun getBookForId(id: Int): Book? {
        bookLiveData.value?.let { books ->
            return books.firstOrNull { it.id == id }
        }
        return null;
    }

    override suspend fun getBookList(): LiveData<List<Book>> {
        return bookLiveData;
    }

    override suspend fun deleteBookForId(id: Int): Boolean {
        val newBooks = bookLiveData.value?.let { books ->
            books.filterNot { it.id == id }
        }
        if (newBooks != null) {
            return if (newBooks.size == initialBookList.size) {
                // No books were deleted.
                false
            } else {
                // Book successfully deleted.
                bookLiveData.value = newBooks
                initialBookList = newBooks
                true
            }
        } else {
            return if (initialBookList.size == 1) {
                // List had one item and it was deleted
                bookLiveData.value = emptyList()
                true
            } else {
                // There were no books to delete from
                false
            }
        }
    }

    companion object {
        private var INSTANCE: MockBookDataSource? = null

        fun getDataSource(resources: Resources): MockBookDataSource {
            return synchronized(MockBookDataSource::class) {
                val newInstance = INSTANCE ?: MockBookDataSource(resources)
                INSTANCE = newInstance
                newInstance
            }

        }
    }
}