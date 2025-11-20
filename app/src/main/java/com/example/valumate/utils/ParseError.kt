package com.example.valumate.utils


import com.example.valumate.model.ErrorResponseModel
import com.google.gson.Gson
import retrofit2.Response

fun parseError(response: Response<*>): String {
    val errorBody = response.errorBody()?.string() ?: ""
    return try {
        val errorResponse = Gson().fromJson(errorBody, ErrorResponseModel::class.java)
        errorResponse.message
    } catch (e: Exception) {
        "An unknown error occurred"
    }
}
