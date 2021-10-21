package com.itj.booksapp.mockData.dataSource

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itj.booksapp.data.bookList
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.BookRepository

class MockBookDataSource(resources: Resources): BookRepository {
    private val initialBookList = bookList(resources)
    private val bookLiveData = MutableLiveData(initialBookList)

    override fun getBookForId(id: Int): Book? {
        bookLiveData.value?.let { books ->
            return books.firstOrNull { it.id == id }
        }
        return null;
    }

    override fun getBookList(): LiveData<List<Book>> {
        return bookLiveData;
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