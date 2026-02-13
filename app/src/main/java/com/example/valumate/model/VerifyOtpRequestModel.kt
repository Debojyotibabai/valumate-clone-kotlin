package com.example.valumate.model

data class VerifyOtpRequestModel(
    val email_address: String,
    val verification_code: String
)
