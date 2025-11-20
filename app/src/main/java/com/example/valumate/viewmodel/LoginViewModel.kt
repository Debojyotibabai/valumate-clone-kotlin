package com.example.valumate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valumate.model.LoginRequestModel
import com.example.valumate.model.LoginResponseModel
import com.example.valumate.repository.LoginRepository
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.utils.parseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {
    private val _loginResponseData = MutableStateFlow<NetworkResponse<LoginResponseModel>>(
        NetworkResponse.Initial
    )

    val loginResponseData: StateFlow<NetworkResponse<LoginResponseModel>> = _loginResponseData

    fun login(loginRequestModel: LoginRequestModel) {
        viewModelScope.launch {
            try {
                _loginResponseData.value = NetworkResponse.Loading

                val response = loginRepository.login(loginRequestModel)

                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        _loginResponseData.value = NetworkResponse.Success(it)
                    }
                } else {
                    _loginResponseData.value = NetworkResponse.Error(parseError(response))
                }
            } catch (err: Exception) {
                _loginResponseData.value = NetworkResponse.Error(err.message.toString())
            }
        }
    }
}
