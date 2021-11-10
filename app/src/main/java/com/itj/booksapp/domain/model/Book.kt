package com.itj.booksapp.domain.model

import androidx.annotation.Nullable
import java.io.Serializable

class Book(
    var isbn: String,
    var title: String,
    var description: String,
    var author: String,
    @Nullable
    var url: String?,
    var publisher: String,
    var publishedDate: String,
    var pages: Long,
    var image: String) : Serializable