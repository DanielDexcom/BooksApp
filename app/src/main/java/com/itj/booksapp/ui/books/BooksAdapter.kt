package com.itj.booksapp.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.databinding.ItemBookBinding

class BooksAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = books[position]
        holder.binding.book = currentBook
    }

    override fun getItemCount(): Int = books.size

    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)
}