package com.itj.booksapp.ui.books

import android.content.Context
import androidx.lifecycle.*
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.mockData.dataSource.MockBookDataSource
import com.itj.booksapp.data.repository.BookRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class BooksViewModel(val booksDataSource: BookRepository) : ViewModel() {
    lateinit var booksLiveData: LiveData<List<Book>>

    init {
        viewModelScope.launch {
            booksLiveData = booksDataSource.getBookList()
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            booksDataSource.deleteBookForId(book.id)
        }
    }
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