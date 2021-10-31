package com.itj.booksapp.data.repository

import com.itj.booksapp.data.model.Book

interface WishListRepository {

    fun getAll(): List<Book>

    fun add(book: Book)

}