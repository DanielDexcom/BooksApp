package com.itj.booksapp.data.repository

import com.itj.booksapp.data.model.Book

interface SearchRepository {

    fun search(isbn: String): Book?

}