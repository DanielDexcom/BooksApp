package com.itj.booksapp.ui.search

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.data.repository.SearchRepository
import com.itj.booksapp.ui.util.ObservableViewModel
import java.lang.Exception
import com.itj.booksapp.BR
import com.itj.booksapp.data.remote.RetrofitBuilder
import com.itj.booksapp.data.remote.source.BookRemoteDataSource
import com.itj.booksapp.ui.util.Resource
import kotlinx.coroutines.launch


class SearchViewModel(val searchRepository: SearchRepository) : ObservableViewModel() {

    private var _isbn = "123"
    var isbn = _isbn

    private val _bookLiveData = MutableLiveData<Resource<Book>?>()
    val bookLiveData: LiveData<Resource<Book>?> = _bookLiveData

    val bookContainerVisibility: LiveData<Int> = _bookLiveData.switchMap { book ->
        val visibility = if (book == null)
            View.GONE
        else
            View.VISIBLE
        MutableLiveData(visibility)
    }

    suspend fun getBookByIsbn(isbn : String) {
        try {
            val book = searchRepository.search(isbn)
            if (book != null) {
                _bookLiveData.value = Resource.success(book)
            }
        }
        catch (ex : Exception) {
            _bookLiveData.value = Resource.error(null, ex.localizedMessage)
        }
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
                    searchRepository = BookRemoteDataSource(RetrofitBuilder.bookRemoteApi)
                ) as T
            }

            throw Exception("Class type not supported.")
        }

    }
}