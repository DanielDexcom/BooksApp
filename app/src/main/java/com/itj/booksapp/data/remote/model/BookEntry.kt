package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookEntry(
    @SerializedName("isbn_13")
     val isbn13: List<String>,

    @SerializedName("number_of_pages")
     val numberOfPages: Long,

    @SerializedName("publishers")
     val publishers: List<String>,

    @SerializedName("covers")
     val covers: List<String>,

    @SerializedName("title")
     val title: String,

    @SerializedName("publish_date")
    val publishDate: String,

    @SerializedName("works")
     val works: List<TypeEntry>,

    @SerializedName("authors")
     val authors: List<TypeEntry>
)
