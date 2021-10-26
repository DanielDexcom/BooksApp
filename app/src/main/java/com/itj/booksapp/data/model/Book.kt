package com.itj.booksapp.data.model

import androidx.annotation.DrawableRes

data class Book (
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val publisher: String,
    val pages: Int,
    val publishedDate: String,
    @DrawableRes
    val image: Int) {

}