package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthorEntry(
    @SerializedName("name")
    val name: String
)
