package com.itj.booksapp.ui.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.databinding.ItemBookBinding
import com.itj.booksapp.ui.util.BookListCallback

class BooksAdapter(
    private var books: List<Book>,
    private val callback: BookListCallback
) :
    RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = books[position]
        holder.binding.book = currentBook
    }

    override fun getItemCount(): Int = books.size

    fun setBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }

    class BookViewHolder(
        val binding: ItemBookBinding,
        private val callback: BookListCallback
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                binding.book?.let { book ->
                    callback.onClick(book)
                }
            }
        }
    }
}