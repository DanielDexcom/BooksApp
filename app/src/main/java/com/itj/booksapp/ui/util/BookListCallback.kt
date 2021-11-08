package com.itj.booksapp.ui.util

import com.itj.booksapp.data.model.Book

interface BookListCallback {
    fun onClick(book: Book)
}