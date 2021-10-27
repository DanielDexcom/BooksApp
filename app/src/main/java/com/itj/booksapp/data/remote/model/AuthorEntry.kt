package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

class AuthorEntry(
    @SerializedName("name")
    val name: String
)