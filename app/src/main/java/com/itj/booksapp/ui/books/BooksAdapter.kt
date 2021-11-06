package com.itj.booksapp.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book

class BooksAdapter(private val books: List<Book>): RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = books.get(position)
        holder.title.text = currentBook.title
        holder.author.text = currentBook.author
        holder.publishDate.text = currentBook.publishedDate
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookViewHolder(rootView: View): RecyclerView.ViewHolder(rootView) {
        val title: TextView = rootView.findViewById(R.id.id_book_title)
        val author: TextView = rootView.findViewById(R.id.id_author_name)
        val publishDate: TextView = rootView.findViewById(R.id.id_publish_date)

    }
}