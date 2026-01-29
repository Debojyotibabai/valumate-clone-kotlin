package com.example.valumate.model

data class SignupRequestModel(
    val above_thirteen: Boolean,
    val accept_term_condition: Boolean,
    val email_address: String,
    val password: String,
    val confirm_password: String
)
