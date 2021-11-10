package com.itj.booksapp.ui.util

import com.itj.booksapp.domain.model.Book

interface BookListCallback {
    fun onClick(book: Book)
}