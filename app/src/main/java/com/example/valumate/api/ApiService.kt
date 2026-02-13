package com.example.valumate.api

import com.example.valumate.model.LoginRequestModel
import com.example.valumate.model.LoginResponseModel
import com.example.valumate.model.SignupRequestModel
import com.example.valumate.model.SignupResponseModel
import com.example.valumate.model.VerifyOtpRequestModel
import com.example.valumate.model.VerifyOtpResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/login")
    suspend fun login(@Body loginRequestModel: LoginRequestModel): Response<LoginResponseModel>

    @POST("/auth/sign_up")
    suspend fun signup(@Body signupRequestModel: SignupRequestModel): Response<SignupResponseModel>

    @POST("/auth/verify_otp")
    suspend fun verifyOtp(@Body verifyOtpRequestModel: VerifyOtpRequestModel): Response<VerifyOtpResponseModel>
}
