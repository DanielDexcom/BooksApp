package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookDetailEntry(
    @SerializedName("description")
    val description: String
)
