package com.itj.booksapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.itj.booksapp.data.local.database.DatabaseManager
import com.itj.booksapp.data.local.source.WishListDataSource
import com.itj.booksapp.data.repository.WishListRepository
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.ui.util.ObservableViewModel
import kotlinx.coroutines.launch

class BookDetailViewModel(private val wishListRepository: WishListRepository) : ObservableViewModel() {

    fun saveBook(book: Book) {
        viewModelScope.launch {
            wishListRepository.add(book)
        }
    }

    class  BookDetailViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(com.itj.booksapp.ui.BookDetailViewModel::class.java)) {
                return BookDetailViewModel(
                    wishListRepository = WishListDataSource(DatabaseManager.instance.database.bookDao())
                ) as T
            }
            throw Exception("Class type not supported.")
        }

    }

}