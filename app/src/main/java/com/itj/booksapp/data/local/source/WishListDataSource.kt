package com.itj.booksapp.data.local.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itj.booksapp.data.local.database.BookDao
import com.itj.booksapp.data.local.model.toBook
import com.itj.booksapp.data.repository.WishListRepository
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.domain.model.toEntity

class WishListDataSource (
    private val bookDao: BookDao
    ) : WishListRepository
{
    suspend override fun getAll(): LiveData<List<Book>> {
        return MutableLiveData(bookDao.getBooksFromWishList().map { it.toBook() })
    }

    suspend override fun add(book: Book) {
        bookDao.save(book.toEntity())
    }

    suspend override fun remove(book: Book): Boolean {
        return bookDao.delete(book.toEntity()) == 1
    }
}