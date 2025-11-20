package com.example.valumate.model

data class LoginResponseModel(
    val access_token: String,
    val email_address: String,
    val is_profile_completed: Boolean,
    val message: String,
    val refresh_token: String,
    val user_id: String
)