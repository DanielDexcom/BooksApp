package com.itj.booksapp.ui.books

import androidx.lifecycle.*
import com.itj.booksapp.data.local.database.DatabaseManager
import com.itj.booksapp.data.local.source.LibraryDataSource
import com.itj.booksapp.data.local.source.WishListDataSource
import com.itj.booksapp.data.mockDataSource.MockWishListDataSource
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.data.repository.WishListRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BooksViewModel(private val wishListRepository: WishListRepository,
                     private val libraryRepository: LibraryDataSource): ViewModel() {

    val books = MutableLiveData<List<Book>>()

    fun addToLibrary(book: Book) {
          viewModelScope.launch {
          wishListRepository.add(book)
        }
    }

    fun getAllBooks() {
        viewModelScope.launch {
            books.value = wishListRepository.getAll().value
        }
    }

    class BooksFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BooksViewModel::class.java)){
                return BooksViewModel(
                    wishListRepository = WishListDataSource(DatabaseManager.instance.database.bookDao()),
                    libraryRepository = LibraryDataSource(DatabaseManager.instance.database.bookDao())
                ) as T
            }
            throw Exception("No class type supported")
        }

    }
}