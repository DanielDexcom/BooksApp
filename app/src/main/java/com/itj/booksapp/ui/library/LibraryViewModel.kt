package com.itj.booksapp.ui.library

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.data.local.database.DatabaseManager
import com.itj.booksapp.data.local.source.LibraryDataSource
import com.itj.booksapp.data.mockDataSource.MockLibraryDataSource
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.data.repository.LibraryRepository
import java.lang.Exception

class LibraryViewModel(private val libraryRepository: LibraryRepository) : ViewModel() {


    val books = MutableLiveData<List<Book>?>()

    suspend fun getLibraryBooks() {
        books.value = libraryRepository.getAll()
    }

    class LibraryViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LibraryViewModel::class.java)) {
                return LibraryViewModel(
                    libraryRepository = LibraryDataSource(DatabaseManager.instance.database.bookDao())
                ) as T
            }
            throw Exception("Model Type not supported")
        }
    }
}