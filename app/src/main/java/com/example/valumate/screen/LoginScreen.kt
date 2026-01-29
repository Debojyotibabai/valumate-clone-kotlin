package com.example.valumate.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.model.LoginRequestModel
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val emailAddressError = remember { mutableStateOf<String?>(null) }
    val passwordError = remember { mutableStateOf<String?>(null) }

    fun login() {
        emailAddressError.value = null
        passwordError.value = null

        var isValid = true

        if (emailAddress.value.isBlank()) {
            emailAddressError.value = "Email is required"
            isValid = false
        }
        if (password.value.isBlank()) {
            passwordError.value = "Password is required"
            isValid = false
        }

        if (!isValid) return

        val loginRequestModel = LoginRequestModel(
            email_address = emailAddress.value, password = password.value
        )

        loginViewModel.login(loginRequestModel)
    }

    val context = LocalContext.current
    val loginState = loginViewModel.loginResponseData.collectAsState()

    LaunchedEffect(loginState.value) {
        when (val state = loginState.value) {
            is NetworkResponse.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
                loginViewModel.resetLoginState()
            }

            is NetworkResponse.Success -> {
                Toast.makeText(context, state.data.message, Toast.LENGTH_LONG).show()
                navHostController.navigate(MainRoutes.DASHBOARD)
                loginViewModel.resetLoginState()
            }

            else -> {
                loginViewModel.resetLoginState()
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        CustomText(
            "Login",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            "Please enter your email and password.",
            fontSize = 14,
            fontWeight = FontWeight.Normal,
            color = AppColors.CharcoalBlack
        )
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            CustomText(
                "Email",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "Enter your email",
                leadingIcon = R.drawable.mail_icon,
                value = emailAddress.value,
                onValueChange = {
                    emailAddress.value = it
                    if (it.isNotBlank()) {
                        emailAddressError.value = null
                    } else {
                        emailAddressError.value = "Email is required"
                    }
                },
                errorMessage = emailAddressError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Password",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "Enter your password",
                leadingIcon = R.drawable.lock_icon,
                value = password.value,
                onValueChange = {
                    password.value = it
                    if (it.isNotBlank()) {
                        passwordError.value = null
                    } else {
                        passwordError.value = "Password is required"
                    }
                },
                errorMessage = passwordError.value
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Forgot Password?",
                fontWeight = FontWeight.Normal,
                fontSize = 13,
                color = AppColors.Gray700,
                modifier = Modifier.clickable {
                    navHostController.navigate(MainRoutes.FORGOT_PASSWORD)
                }
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            onClick = {
                login()
            },
            text = "Login",
            isLoading = loginState.value is NetworkResponse.Loading
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            buildAnnotatedString {
                append("New Users Click Here to ")
                withStyle(
                    style = SpanStyle(
                        color = AppColors.MidnightBlue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Sign up")
                }
            }, style = TextStyle(
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = AppColors.Gray700,
            ),
            modifier = Modifier.clickable {
                navHostController.navigate(MainRoutes.SIGNUP)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}
