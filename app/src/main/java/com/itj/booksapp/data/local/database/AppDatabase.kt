package com.itj.booksapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itj.booksapp.data.local.model.BookEntity

const val DATABASE_VERSION = 1
const val TABLE_BOOKS = "book"
const val DATABASE_NAME = "bootcamp.sqlite"

@Database(
    entities = [BookEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}