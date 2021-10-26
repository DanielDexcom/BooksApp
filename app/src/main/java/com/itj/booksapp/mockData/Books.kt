package com.itj.booksapp.data

import android.content.res.Resources
import com.itj.booksapp.R
import com.itj.booksapp.data.model.Book

fun bookList(resources: Resources): List<Book> {
    return listOf (
        Book(
            id = 1,
            title = resources.getString(R.string.book_lord_rings),
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 123,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        ),
        Book(
            id = 2,
            title = "Second",
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 456,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        ),
        Book(
            id = 3,
            title = "Third",
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 789,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        ),
        Book(
            id = 4,
            title = "Fourth",
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 456,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        ),
        Book(
            id = 5,
            title = "Fifth",
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 789,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        ),
        Book(
            id = 6,
            title = "Sixth",
            author = resources.getString(R.string.author_tolkien),
            description = resources.getString(R.string.description_lorem_ipsum),
            publisher = resources.getString(R.string.publisher_lorem_ipsum),
            pages = 789,
            publishedDate = resources.getString(R.string.date_sept),
            image = R.drawable.ic_baseline_book_24dp
        )
    )
}
