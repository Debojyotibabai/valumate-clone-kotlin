package com.example.valumate.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valumate.model.VerifyOtpRequestModel
import com.example.valumate.model.VerifyOtpResponseModel
import com.example.valumate.repository.VerifyOtpRepository
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.utils.parseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerifyOtpViewModel @Inject constructor(private val verifyOtpRepository: VerifyOtpRepository) :
    ViewModel() {
    private val _verifyOtpState = MutableStateFlow<NetworkResponse<VerifyOtpResponseModel>>(
        NetworkResponse.Initial
    )

    val verifyOtpState: StateFlow<NetworkResponse<VerifyOtpResponseModel>> = _verifyOtpState

    fun verifyOtp(verifyOtpRequestModel: VerifyOtpRequestModel) {
        viewModelScope.launch {
            try {
                _verifyOtpState.value = NetworkResponse.Loading

                val response = verifyOtpRepository.verifyOtp(verifyOtpRequestModel)

                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        _verifyOtpState.value = NetworkResponse.Success(it)
                    }
                } else {
                    _verifyOtpState.value = NetworkResponse.Error(parseError(response))
                }
            } catch (err: Exception) {
                Log.d("verify otp error", err.toString())
                _verifyOtpState.value =
                    NetworkResponse.Error(err.message ?: "Something went wrong")
            }
        }
    }

    fun resetVerifyOtpState() {
        _verifyOtpState.value = NetworkResponse.Initial
    }
}
