package com.itj.booksapp.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.data.mockDataSource.MockWishListDataSource
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.data.repository.WishListRepository
import java.lang.Exception

class BooksViewModel(private val wishListRepository: WishListRepository): ViewModel() {

    val books: LiveData<List<Book>> = wishListRepository.getAll()

    fun addToLibrary(book: Book) {
        wishListRepository.remove(book)
    }

    class BooksFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BooksViewModel::class.java)){
                return BooksViewModel(
                    wishListRepository = MockWishListDataSource()
                ) as T
            }
            throw Exception("No class type supported")
        }

    }
}