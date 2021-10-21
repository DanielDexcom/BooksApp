package com.itj.booksapp.data.repository

import androidx.lifecycle.LiveData
import com.itj.booksapp.data.model.Book

interface BookRepository {
    fun getBookForId(id: Int): Book?
    fun getBookList(): LiveData<List<Book>>
}