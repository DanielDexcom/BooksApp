package com.itj.booksapp.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.itj.booksapp.R
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.ui.books.AddBookAndDetailDialogDirections
import com.itj.booksapp.ui.books.BooksViewModel

class ReadBookAndDetailDialog : DialogFragment() {

    private lateinit var viewModel: BooksViewModel
    private lateinit var book: Book

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val booksFactory = BooksViewModel.BooksFactory()
        viewModel = ViewModelProvider(this, booksFactory).get(BooksViewModel::class.java)
        val view = inflater.inflate(R.layout.read_and_detail_dialog, container, false)
        val btnReadBook: Button = view.findViewById(R.id.read_button)
        val btnDetail: Button = view.findViewById(R.id.detail_button)

        btnReadBook.setOnClickListener {
            val directions = ReadBookAndDetailDialogDirections.actionReadAndDetailDialogToExampleFragment(book)
            NavHostFragment.findNavController(this).navigate(directions)
            dismiss()
        }
        btnDetail.setOnClickListener {
            val directions = ReadBookAndDetailDialogDirections.actionReadAndDetailDialogToBookDetailFragment(book)
            NavHostFragment.findNavController(this).navigate(directions)
            dismiss()
        }
        return view
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        if (args != null && args.containsKey(BOOK)) {
            book = args[BOOK] as Book
        }
    }

    companion object {
        const val BOOK = "book_arg"
    }
}