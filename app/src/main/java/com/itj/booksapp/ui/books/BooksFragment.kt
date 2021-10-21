package com.itj.booksapp.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itj.booksapp.MainActivity
import com.itj.booksapp.R
import com.itj.booksapp.databinding.FragmentBooksBinding
import com.itj.booksapp.ui.BooksAdapter


class BooksFragment : Fragment() {

    private lateinit var booksViewModel: BooksViewModel
    private var _binding: FragmentBooksBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View {

        _binding = FragmentBooksBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val root: View = binding.root

        val viewModelFactory = BookListViewModelFactory(application)
        booksViewModel =
            ViewModelProvider(this, viewModelFactory).get(BooksViewModel::class.java)

        (activity as MainActivity).supportActionBar?.title = getString(R.string.title_toolbar_books)
        binding.idBookWishList

        // Uncomment to see RecyclerView
//        val adapter = BooksAdapter()
//        binding.idBookWishList.adapter = adapter
//        booksViewModel.booksLiveData.observe(viewLifecycleOwner, {
//            it?.let {
//                adapter.data = it
//            }
//        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}