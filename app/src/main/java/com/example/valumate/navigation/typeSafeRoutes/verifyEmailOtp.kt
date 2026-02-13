package com.example.valumate.navigation.typeSafeRoutes

import kotlinx.serialization.Serializable

@Serializable
data class VerifyEmailOtp(
    val email: String
)
