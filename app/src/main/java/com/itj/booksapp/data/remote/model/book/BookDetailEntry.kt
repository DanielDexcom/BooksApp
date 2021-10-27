package com.itj.booksapp.data.remote.model.book

import com.google.gson.annotations.SerializedName

class BookDetailEntry(
    @SerializedName("description")
    val description: String,
)