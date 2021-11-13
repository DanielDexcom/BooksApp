package com.itj.booksapp.ui.library

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.itj.booksapp.R
import com.itj.booksapp.domain.model.Book
import com.itj.booksapp.ui.util.BookListCallback
import kotlinx.coroutines.launch

class LibraryFragment : Fragment() , BookListCallback {

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
        viewModel.books.observe(viewLifecycleOwner) { books ->
            libraryList.adapter = viewModel.books.value?.let {
                LibraryAdapter(it,this)
            }
        }
        lifecycleScope.launch() {
            viewModel.getLibraryBooks()
        }
    }

    override fun onClick(book: Book) {
        val directions = LibraryFragmentDirections.actionNavigationLibraryToReadAndDetailDialog(book)
        NavHostFragment.findNavController(this).navigate(directions)
    }

}