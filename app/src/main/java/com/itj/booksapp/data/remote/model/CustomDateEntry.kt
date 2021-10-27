package com.itj.booksapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CustomDateEntry(
    @SerializedName("type")
    val type: String,

    @SerializedName("value")
    val value: String
)