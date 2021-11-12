package com.itj.booksapp.data.local.database

import androidx.room.*
import com.itj.booksapp.data.local.model.BookEntity

@Dao
interface BookDao {

    @Query("SELECT * FROM $TABLE_BOOKS where url =''")
    suspend fun getBooksFromWishList(): List<BookEntity>

    @Query("SELECT * FROM $TABLE_BOOKS where url !=''")
    suspend fun getBooksFromLibrary(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(book : BookEntity)

    @Delete
    suspend fun delete(book: BookEntity) : Int

}