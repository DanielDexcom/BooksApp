package com.itj.booksapp.ui.books

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.itj.booksapp.R

class BooksFragment : Fragment() {

    companion object {
        fun newInstance() = BooksFragment()
    }

    private lateinit var viewModel: BooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.books_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextButton: Button = view.findViewById(R.id.button_next)
        nextButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_navigationBooks_to_exampleFragment)
        }

    }

}