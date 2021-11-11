package com.itj.booksapp.ui.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.itj.booksapp.R
import com.squareup.picasso.Picasso

object BindingAdapters {

    @BindingAdapter("loadBookImage")
    @JvmStatic
    fun loadBookImage(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Picasso.get().load(url).into(view)
        } else {
            Picasso.get().load(R.drawable.ic_baseline_book_cover).into(view)
        }
    }

}