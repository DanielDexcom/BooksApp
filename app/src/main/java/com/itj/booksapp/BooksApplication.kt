package com.itj.booksapp

import android.app.Application
import com.itj.booksapp.data.local.database.DatabaseManager

open class BooksApplication: Application() {

   override fun onCreate() {
       DatabaseManager.instance.initializeDb(applicationContext)
       super.onCreate()
   }

}