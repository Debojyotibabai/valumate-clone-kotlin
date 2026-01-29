package com.example.valumate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valumate.model.SignupRequestModel
import com.example.valumate.model.SignupResponseModel
import com.example.valumate.repository.SignupRepository
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.utils.parseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val signupRepository: SignupRepository) :
    ViewModel() {
    private val _signupResponseData = MutableStateFlow<NetworkResponse<SignupResponseModel>>(
        NetworkResponse.Initial
    )

    val signupResponseData: StateFlow<NetworkResponse<SignupResponseModel>> = _signupResponseData

    fun signup(signupRequestModel: SignupRequestModel) {
        viewModelScope.launch {
            try {
                _signupResponseData.value = NetworkResponse.Loading

                val response = signupRepository.signup(signupRequestModel)

                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        _signupResponseData.value = NetworkResponse.Success(it)
                    }
                } else {
                    _signupResponseData.value = NetworkResponse.Error(parseError(response))
                }
            } catch (err: Exception) {
                _signupResponseData.value = NetworkResponse.Error(err.message.toString())
            }
        }
    }

    fun resetSignupState() {
        _signupResponseData.value = NetworkResponse.Initial
    }
}
