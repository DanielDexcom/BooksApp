package com.itj.booksapp.data.repository

import com.itj.booksapp.domain.model.Book

interface LibraryRepository {

    suspend fun getAll(): List<Book>

    suspend fun add(book: Book)

}