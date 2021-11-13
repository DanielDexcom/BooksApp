package com.itj.booksapp.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itj.booksapp.R
import com.itj.booksapp.databinding.BookDetailFragmentBinding
import com.itj.booksapp.domain.model.Book

class BookDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BookDetailFragment()
    }

    private lateinit var viewModel: BookDetailViewModel
    private lateinit var binding: BookDetailFragmentBinding
    private lateinit var detailBook : Book

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBook = arguments?.getSerializable("book_arg") as Book
        binding = BookDetailFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            book = detailBook
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = BookDetailViewModel.BookDetailViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(BookDetailViewModel::class.java)
        binding.addListButton.setOnClickListener {
            viewModel.saveBook(detailBook)
        }

        binding.getBookButton.setOnClickListener {
            val url = "https://www.amazon.com/s?k=${detailBook.isbn}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}