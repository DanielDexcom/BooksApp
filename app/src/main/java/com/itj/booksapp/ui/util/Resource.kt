package com.itj.booksapp.ui.util

data class Resource<out T>(val status: Status,val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = Status.SUCCCESS, data = data, message = null)
        fun <T> error(data: T?, message: String): Resource<T> = Resource(Status.ERRROR, data, message)
    }
}
