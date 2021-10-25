package com.itj.booksapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.databinding.ItemBookBinding

class BooksAdapter(private val bookListCallback: BookListCallback) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    var books = listOf<Book>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding: ItemBookBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book,
            parent,
            false
        )
        return BooksViewHolder(binding, bookListCallback)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BooksViewHolder(
        private val bookBinding: ItemBookBinding,
        bookListCallback: BookListCallback
    ) :
        RecyclerView.ViewHolder(bookBinding.root) {

        init {
            bookBinding.root.setOnLongClickListener {
                bookBinding.book?.let {
                    bookListCallback.onLongClick(it)
                }
                true
            }
        }

        fun bind(book: Book) {
            bookBinding.book = book
        }
    }

    interface BookListCallback {
        fun onLongClick(book: Book)
        fun onClick(book: Book)
    }
}