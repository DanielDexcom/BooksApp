package com.itj.booksapp.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.ui.books.AddBookAndDetailDialog.Companion.BOOK
import com.itj.booksapp.ui.util.BookListCallback

class BooksFragment : Fragment(), BookListCallback {

    companion object {
        fun newInstance() = BooksFragment()
    }

    private lateinit var viewModel: BooksViewModel
    private lateinit var bookList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.books_fragment, container, false)
        bookList = rootView.findViewById(R.id.book_list)

        val booksFactory = BooksViewModel.BooksFactory()
        viewModel = ViewModelProvider(this, booksFactory).get(BooksViewModel::class.java)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.books.observe(viewLifecycleOwner) { books ->
            var adapter = bookList.adapter
            if (adapter == null) {
                adapter = BooksAdapter(books, this)
                bookList.adapter = adapter
            } else {
                (bookList.adapter as BooksAdapter).setBooks(books)
            }
        }
        viewModel.getAllBooks()
    }

    override fun onClick(book: Book) {
        val directions = BooksFragmentDirections.actionNavigationBooksToAddBookDetailDialog(book)
        directions.arguments.putSerializable(BOOK, book)
        findNavController(this).navigate(directions)
    }

}