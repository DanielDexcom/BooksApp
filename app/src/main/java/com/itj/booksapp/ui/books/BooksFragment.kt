package com.itj.booksapp.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.MainActivity
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book
import com.itj.booksapp.databinding.FragmentBooksBinding
import com.itj.booksapp.ui.BooksAdapter


class BooksFragment : Fragment(), BooksAdapter.BookListCallback {

    private lateinit var viewModel: BooksViewModel
    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false).apply {
            booksViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = BookListViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BooksViewModel::class.java)

        (activity as MainActivity).supportActionBar?.title = getString(R.string.title_toolbar_books)

        // Uncomment to see RecyclerView
        val adapter = BooksAdapter(this)
        binding.idBookWishList.adapter = adapter
        viewModel.booksLiveData.observe(viewLifecycleOwner) { books ->
            books?.let {
                adapter.books = books
            }
        }
    }

    override fun onLongClick(book: Book) {
        viewModel.deleteBook(book)
    }

    override fun onClick(book: Book) {
        TODO("Not yet implemented")
    }
}