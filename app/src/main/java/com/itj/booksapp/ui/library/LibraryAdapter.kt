package com.itj.booksapp.ui.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.databinding.ItemBookBinding
import com.itj.booksapp.ui.util.BookListCallback

class LibraryAdapter(private val books: List<Book>,
                     private val callBack: BookListCallback) :
    RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibraryViewHolder(binding,callBack)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val currentBook = books[position]
        holder.binding.book = currentBook
    }

    override fun getItemCount(): Int = books.size

    class LibraryViewHolder(
        val binding: ItemBookBinding,
        val callBack: BookListCallback) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                binding.book?.let { book ->
                    callBack.onClick(book)
                }
            }
        }


        }

}