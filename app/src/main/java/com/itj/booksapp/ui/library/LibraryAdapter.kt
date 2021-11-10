package com.itj.booksapp.ui.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.databinding.ItemBookBinding

class LibraryAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibraryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val currentBook = books[position]
        holder.binding.book = currentBook
    }

    override fun getItemCount(): Int = books.size

    class LibraryViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

}