package com.itj.booksapp.data.repository

import androidx.lifecycle.LiveData
import com.itj.booksapp.data.model.Book

interface BookRepository {
    /**
     * Returns the book corresponding to the given ID. If there is no book with such id, it will
     * return null
     */
    fun getBookForId(id: Int): Book?

    /**
     * Returns a list of all the books in the repository
     */
    fun getBookList(): LiveData<List<Book>>

    /**
     * Deletes a book from the current repository
     *
     * Returns true if the book was deleted. False if not
     */
    fun deleteBookForId(id: Int): Boolean
}