package com.itj.booksapp.ui.read

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.itj.booksapp.R
import com.itj.booksapp.domain.model.Book

class ReadFragment : Fragment() {

    companion object {
        fun newInstance() = ReadFragment()
    }

    private lateinit var viewModel: ExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.read_fragment, container, false)
        val readWebView: WebView = rootView.findViewById(R.id.readWebView)
        val book = arguments?.getSerializable("book_arg") as Book

        readWebView.settings.useWideViewPort = true
        readWebView.settings.loadWithOverviewMode = true

        book.url?.let { url ->
            readWebView.loadUrl(url)
        }

        (activity as AppCompatActivity).supportActionBar?.title = book.title
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExampleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}