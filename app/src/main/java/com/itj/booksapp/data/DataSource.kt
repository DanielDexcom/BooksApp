package com.itj.booksapp.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialBookList = bookList(resources)
    private val bookLiveData = MutableLiveData(initialBookList)

    fun getBookForId(id: Int): Book? {
        bookLiveData.value?.let { books ->
            return books.firstOrNull { it.id == id }
        }
        return null;
    }

    fun getBookList(): LiveData<List<Book>> {
        return bookLiveData;
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }

        }
    }
}