package com.itj.booksapp.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.R
import com.itj.booksapp.domain.model.Book

class AddBookDialog : DialogFragment() {
    private lateinit var viewModel: BooksViewModel
    private lateinit var book : Book

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val booksFactory = BooksViewModel.BooksFactory()
        viewModel = ViewModelProvider(this,booksFactory).get(BooksViewModel::class.java)
        val view = inflater.inflate(R.layout.add_book_dialog, container, false)
        val btnAddBook: Button = view.findViewById(R.id.add_book)
        val urlEditText: EditText = view.findViewById(R.id.book_url)

        btnAddBook.setOnClickListener {
            if (urlEditText.text.isNotEmpty()) {
                urlEditText.error = null
                book.url = urlEditText.text.toString()
                viewModel.addToLibrary(book)
                dismiss()
            } else {
                urlEditText.error = getString(R.string.please_add_an_url)
            }
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