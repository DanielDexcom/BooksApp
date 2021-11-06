package com.itj.booksapp.ui.library

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R

class LibraryFragment : Fragment() {

    companion object {
        fun newInstance() = LibraryFragment()
    }

    private lateinit var viewModel: LibraryViewModel
    private lateinit var libraryList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.library_fragment, container, false)
        libraryList = view.findViewById(R.id.libraryBooks)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = LibraryViewModel.LibraryViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(LibraryViewModel::class.java)
        libraryList.adapter = LibraryAdapter(viewModel.books)
    }

}