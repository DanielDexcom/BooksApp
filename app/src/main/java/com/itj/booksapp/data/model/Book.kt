package com.itj.booksapp.data.model

import java.io.Serializable

class Book(
    var isbn: String,
    var title: String,
    var description: String,
    var author: String,
    var url: String,
    var publisher: String,
    var publishedDate: String,
    var pages: Int,
    var image: String) : Serializable