package com.itj.booksapp.data.repository

import com.itj.booksapp.domain.model.Book

interface LibraryRepository {

    fun getAll(): List<Book>

    fun add(book: Book)

}