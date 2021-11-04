package com.itj.booksapp.ui.example

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itj.booksapp.R

class ExampleFragment : Fragment() {

    companion object {
        fun newInstance() = ExampleFragment()
    }

    private lateinit var viewModel: ExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.example_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExampleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}