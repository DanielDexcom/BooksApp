package com.itj.booksapp.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.ui.BooksAdapter

@BindingAdapter("booksData")
fun bindingBooks(recyclerView: RecyclerView, books: List<Book>?) {
    books?.let {
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.books = it
    }
}

fun getOrCreateAdapter(recyclerView: RecyclerView): BooksAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BooksAdapter) {
        recyclerView.adapter as BooksAdapter
    } else {
        val booksAdapter = BooksAdapter()
        recyclerView.adapter = booksAdapter
        return booksAdapter
    }
}
