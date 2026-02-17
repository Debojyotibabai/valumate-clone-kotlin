package com.example.valumate.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valumate.model.ForgotPasswordRequestModel
import com.example.valumate.model.ForgotPasswordResponseModel
import com.example.valumate.repository.ForgotPasswordRepository
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.utils.parseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val forgotPasswordRepository: ForgotPasswordRepository) :
    ViewModel() {
    private val _forgotPasswordState =
        MutableStateFlow<NetworkResponse<ForgotPasswordResponseModel>>(
            NetworkResponse.Initial
        )

    val forgotPasswordState: StateFlow<NetworkResponse<ForgotPasswordResponseModel>> =
        _forgotPasswordState

    fun forgotPassword(forgotPasswordRequestModel: ForgotPasswordRequestModel) {
        viewModelScope.launch {
            try {
                _forgotPasswordState.value = NetworkResponse.Loading

                val response = forgotPasswordRepository.forgotPassword(forgotPasswordRequestModel)

                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        _forgotPasswordState.value = NetworkResponse.Success(it)
                    }
                } else {
                    Log.d("forgot Password error", response.message())
                    _forgotPasswordState.value = NetworkResponse.Error(parseError(response))
                }
            } catch (err: Exception) {
                Log.d("forgot Password error", err.message.toString())
                _forgotPasswordState.value =
                    NetworkResponse.Error(err.message ?: "Something went wrong")
            }
        }
    }

    fun resetForgotPasswordState() {
        _forgotPasswordState.value = NetworkResponse.Initial
    }
}
