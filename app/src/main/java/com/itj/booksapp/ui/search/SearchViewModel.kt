package com.itj.booksapp.ui.search

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.itj.booksapp.data.mockDataSource.MockSearchDataSource
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.data.repository.SearchRepository
import com.itj.booksapp.ui.util.ObservableViewModel
import java.lang.Exception
import com.itj.booksapp.BR

class SearchViewModel(val searchRepository: SearchRepository) : ObservableViewModel() {

    private var _isbn = "123"
    var isbn: String
        @Bindable get() = _isbn
        set(value) {
            if (value != _isbn) {
                _isbn = value
                _bookLiveData.value = searchRepository.search(_isbn)
                notifyPropertyChanged(BR.isbn)
            }
        }

    private val _bookLiveData = MutableLiveData<Book?>(searchRepository.search(_isbn))
    val bookLiveData: LiveData<Book?> = _bookLiveData

    val bookContainerVisibility: LiveData<Int> = _bookLiveData.switchMap { book ->
        val visibility = if (book == null)
            View.GONE
        else
            View.VISIBLE
        MutableLiveData(visibility)
    }

    val searchContainerVisibility: LiveData<Int> =
        bookContainerVisibility.switchMap { bookContainerVisibility ->
            val visibility = if (bookContainerVisibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
            MutableLiveData(visibility)
        }

    class SearchViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
                return SearchViewModel(
                    searchRepository = MockSearchDataSource()
                ) as T
            }

            throw Exception("Class type not supported.")
        }

    }
}