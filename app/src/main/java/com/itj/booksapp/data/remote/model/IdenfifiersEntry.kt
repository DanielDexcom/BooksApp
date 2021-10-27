package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class IdentifiersEntry(
    @SerializedName("goodreads")
    val goodreads: List<String>,

    @SerializedName("librarything")
    val librarything: List<String>
)