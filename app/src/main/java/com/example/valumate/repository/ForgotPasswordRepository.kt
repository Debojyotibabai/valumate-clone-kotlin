package com.example.valumate.repository

import com.example.valumate.api.ApiService
import com.example.valumate.model.ForgotPasswordRequestModel
import com.example.valumate.model.ForgotPasswordResponseModel
import retrofit2.Response
import javax.inject.Inject

class ForgotPasswordRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun forgotPassword(forgotPasswordRequestModel: ForgotPasswordRequestModel): Response<ForgotPasswordResponseModel> {
        return apiService.forgotPassword(forgotPasswordRequestModel)
    }
}
