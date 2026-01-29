package com.example.valumate.repository

import com.example.valumate.api.ApiService
import com.example.valumate.model.SignupRequestModel
import com.example.valumate.model.SignupResponseModel
import retrofit2.Response
import javax.inject.Inject

class SignupRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun signup(signupRequestModel: SignupRequestModel): Response<SignupResponseModel> {
        return apiService.signup(signupRequestModel)
    }
}
