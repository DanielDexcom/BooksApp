package com.itj.booksapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book

class BooksAdapter: RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    var data = listOf<Book>()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class BooksViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        // Change to binding
        private val bookTitleTextView: TextView = itemView.findViewById(R.id.id_book_title)
        private val bookCoverImageView: ImageView = itemView.findViewById(R.id.id_book_image)
        private val authorTextView: TextView = itemView.findViewById(R.id.id_author_name)
        private val publishDateTextView: TextView = itemView.findViewById(R.id.id_publish_date)

        fun bind(book: Book) {
            bookTitleTextView.text = book.title
            bookCoverImageView.setImageResource(book.image)
            authorTextView.text = book.author
            publishDateTextView.text = book.publishedDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_book, parent, false)
                as CardView
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}