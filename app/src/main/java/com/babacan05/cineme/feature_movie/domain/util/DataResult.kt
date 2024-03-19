package com.babacan05.cineme.feature_movie.domain.util

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val message: String) : DataResult<Nothing>()

}