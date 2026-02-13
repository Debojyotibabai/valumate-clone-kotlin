package com.example.valumate.repository

import com.example.valumate.api.ApiService
import com.example.valumate.model.VerifyOtpRequestModel
import com.example.valumate.model.VerifyOtpResponseModel
import retrofit2.Response
import javax.inject.Inject

class VerifyOtpRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun verifyOtp(verifyOtpRequestModel: VerifyOtpRequestModel): Response<VerifyOtpResponseModel> {
        return apiService.verifyOtp(verifyOtpRequestModel)
    }
}
