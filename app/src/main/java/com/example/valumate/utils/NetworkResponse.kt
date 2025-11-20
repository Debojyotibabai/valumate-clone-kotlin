package com.example.valumate.utils

sealed class NetworkResponse<out T> {
    object Initial : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
    data class Success<out T>(val data: T) : NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
}
