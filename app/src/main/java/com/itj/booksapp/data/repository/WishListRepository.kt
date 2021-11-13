package com.itj.booksapp.data.repository

import androidx.lifecycle.LiveData
import com.itj.booksapp.domain.model.Book

interface WishListRepository {

    suspend fun getAll(): LiveData<List<Book>>

    suspend fun add(book: Book)

    /**
     * @return true when a book was deleted. False if not
     */
    suspend fun remove(book: Book): Boolean

}