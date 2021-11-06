package com.itj.booksapp.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R

class BooksFragment : Fragment() {

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
        val adapter = BooksAdapter(viewModel.books)
        bookList.adapter = adapter
    }

}