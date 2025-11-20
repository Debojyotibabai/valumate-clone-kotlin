package com.example.valumate.repository

import com.example.valumate.api.ApiService
import com.example.valumate.model.LoginRequestModel
import com.example.valumate.model.LoginResponseModel
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun login(loginRequestModel: LoginRequestModel): Response<LoginResponseModel> {
        return apiService.login(loginRequestModel)
    }
}
