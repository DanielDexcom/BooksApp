package com.itj.booksapp.data.repository

import androidx.lifecycle.LiveData
import com.itj.booksapp.domain.model.Book

interface WishListRepository {

    fun getAll(): LiveData<List<Book>>

    fun add(book: Book)

    /**
     * @return true when a book was deleted. False if not
     */
    fun remove(book: Book): Boolean

}