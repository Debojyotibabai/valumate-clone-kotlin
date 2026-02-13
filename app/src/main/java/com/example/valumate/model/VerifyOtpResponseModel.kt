package com.example.valumate.model

data class VerifyOtpResponseModel(
    val access_token: String,
    val message: String,
    val refresh_token: String,
    val user_id: String
)