package com.example.valumate.api

import com.example.valumate.model.LoginRequestModel
import com.example.valumate.model.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/login")
    suspend fun login(@Body loginRequestModel: LoginRequestModel): Response<LoginResponseModel>
}
