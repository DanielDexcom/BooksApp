package com.itj.booksapp.ui.books

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.mockData.dataSource.MockBookDataSource
import com.itj.booksapp.data.repository.BookRepository
import java.lang.IllegalArgumentException

class BooksViewModel (val booksDataSource: BookRepository): ViewModel() {
    val booksLiveData = booksDataSource.getBookList()
}

class BookListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BooksViewModel(
                booksDataSource = MockBookDataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}