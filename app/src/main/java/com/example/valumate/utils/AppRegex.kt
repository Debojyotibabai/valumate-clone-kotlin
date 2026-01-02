package com.example.valumate.utils

object AppRegex {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    val passwordRegex = Regex(
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#^*_?{}-])[A-Za-z\\d!@#^*_?{}-]{8,}$"
    )
}
