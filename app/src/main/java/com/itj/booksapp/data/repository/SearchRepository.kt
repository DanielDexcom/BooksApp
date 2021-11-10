package com.itj.booksapp.data.repository

import com.itj.booksapp.domain.model.Book

interface SearchRepository {

    suspend fun search(isbn: String): Book?

}