package com.itj.booksapp.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book

class AddBookAndDetailDialog : DialogFragment() {
    private lateinit var viewModel: BooksViewModel
    private lateinit var book: Book

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val booksFactory = BooksViewModel.BooksFactory()
        viewModel = ViewModelProvider(this, booksFactory).get(BooksViewModel::class.java)
        val view = inflater.inflate(R.layout.add_book_and_detail_dialog, container, false)
        val btnAddBook: Button = view.findViewById(R.id.add_book)
        val btnDetail: Button = view.findViewById(R.id.detail)

        btnAddBook.setOnClickListener {
            viewModel.addToLibrary(book)
            dismiss()
        }
        btnDetail.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_navigationAddBookDetailDialog_to_bookDetailFragment)
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