package com.itj.booksapp.data.local.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itj.booksapp.data.local.database.TABLE_BOOKS
import com.itj.booksapp.domain.model.Book

@Entity(tableName = TABLE_BOOKS)
data class BookEntity(
    @PrimaryKey val isbn: String,
    val title: String,
    val author: String,
    val description: String,
    val publisher: String,
    val pages: Long,
    val publishedDate: String,
    @ColumnInfo(name = "image")
    val image: String,
    @Nullable
    val url: String?
)

fun BookEntity.toBook() = Book(
    isbn,
    title,
    description,
    author,
    url,
    publisher,
    publishedDate,
    pages,
    image
)