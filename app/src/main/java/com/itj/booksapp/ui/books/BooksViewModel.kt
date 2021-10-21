package com.itj.booksapp.ui.books

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.data.DataSource
import java.lang.IllegalArgumentException

class BooksViewModel (val dataSource: DataSource): ViewModel() {
    val booksLiveData = dataSource.getBookList()
}

class BookListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BooksViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}