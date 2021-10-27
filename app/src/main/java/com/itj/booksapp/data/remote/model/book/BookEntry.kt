package com.itj.booksapp.data.remote.model.book

import com.google.gson.annotations.SerializedName
import com.itj.booksapp.data.remote.model.CustomDateEntry
import com.itj.booksapp.data.remote.model.IdentifiersEntry
import com.itj.booksapp.data.remote.model.TypeEntry

class BookEntry(
    @SerializedName("publishers")
    val publishers: List<String>,

    @SerializedName("number_of_pages")
    val numberOfPages: Long,

    @SerializedName("isbn_10")
    val isbn10: List<String>,

    @SerializedName("covers")
    val covers: List<Long>,

    @SerializedName("key")
    val key: String,

    @SerializedName("authors")
    val authors: List<TypeEntry>,

    @SerializedName("ocaid")
    val ocaid: String,

    @SerializedName("contributions")
    val contributions: List<String>,

    @SerializedName("languages")
    val languages: List<TypeEntry>,

    @SerializedName("classifications")
    val classifications: TypeEntry,

    @SerializedName("source_records")
    val sourceRecords: List<String>,

    @SerializedName("title")
    val title: String,

    @SerializedName("identifiers")
    val identifiers: IdentifiersEntry,

    @SerializedName("isbn_13")
    val isbn13: List<String>,

    @SerializedName("local_id")
    val localID: List<String>,

    @SerializedName("publish_date")
    val publishDate: String,

    @SerializedName("works")
    val works: List<TypeEntry>,

    @SerializedName("type")
    val edition: TypeEntry,

    @SerializedName("first_sentence")
    val firstSentence: TypeEntry,

    @SerializedName("latest_revision")
    val latestRevision: Long,

    @SerializedName("revision")
    val revision: Long,

    @SerializedName("created")
    val created: CustomDateEntry,

    @SerializedName("last_modified")
    val lastModified: CustomDateEntry
)