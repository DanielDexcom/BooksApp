package com.itj.booksapp.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.itj.booksapp.R
import com.itj.booksapp.databinding.SearchFragmentBinding
import com.itj.booksapp.ui.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment(), SearchView.OnQueryTextListener{

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: SearchFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val searchOptions = menu.findItem(R.id.search)
        val searchView = searchOptions.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val factory = SearchViewModel.SearchViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)

        binding = SearchFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@SearchFragment.viewModel
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.bookLiveData.observe(viewLifecycleOwner) { result ->
           when (result?.status) {
               Status.ERRROR -> {
                   Toast.makeText(context,result?.message,Toast.LENGTH_LONG).show()
               }
               Status.SUCCCESS -> {

               }
           }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.getBookByIsbn(query)
            }
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        return false
    }

}