package com.itj.booksapp.ui.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.data.mockDataSource.MockLibraryDataSource
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.LibraryRepository
import java.lang.Exception

class LibraryViewModel(libraryRepository: LibraryRepository) : ViewModel() {
    val books: List<Book> = libraryRepository.getAll()

    class LibraryViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LibraryViewModel::class.java)) {
                return LibraryViewModel(
                    libraryRepository = MockLibraryDataSource()
                ) as T
            }
            throw Exception("Model Type not supported")
        }

    }
}