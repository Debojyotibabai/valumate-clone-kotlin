package com.example.valumate.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
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
import com.example.valumate.model.SignupRequestModel
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.navigation.typeSafeRoutes.VerifyEmailOtp
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins
import com.example.valumate.utils.AppRegex
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.viewmodel.SignupViewModel

@Composable
fun SignupScreen(
    navHostController: NavHostController,
    signupViewModel: SignupViewModel = hiltViewModel(),
) {
    val passwordConditions: Array<String> = arrayOf(
        "At least one uppercase letter",
        "At least one lowercase letter",
        "At least one numeral (0-9)",
        "At least one special symbol (!@#^*_?{}-)",
        "Minimum of 8 characters"
    )

    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    val isAgeConfirmed = remember { mutableStateOf(false) }
    val isTermsAccepted = remember { mutableStateOf(false) }

    val emailAddressError = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf("") }
    val confirmPasswordError = remember { mutableStateOf("") }

    val context = LocalContext.current
    val signupState = signupViewModel.signupResponseData.collectAsState()

    fun signup() {
        emailAddressError.value = ""
        passwordError.value = ""
        confirmPasswordError.value = ""

        if (emailAddress.value.isBlank()) {
            emailAddressError.value = "Email is required"
        } else if (!emailAddress.value.matches(AppRegex.emailRegex)) {
            emailAddressError.value = "Invalid email"
        }

        if (password.value.isBlank()) {
            passwordError.value = "Password is required"
        } else if (!password.value.matches(AppRegex.passwordRegex)) {
            passwordError.value = "Password must match the criteria"
        }

        if (confirmPassword.value.isBlank()) {
            confirmPasswordError.value = "Confirm password is required"
        } else if (confirmPassword.value != password.value) {
            confirmPasswordError.value = "Passwords do not match"
        }


        if (emailAddressError.value.isNotBlank() || passwordError.value.isNotBlank() || confirmPasswordError.value.isNotBlank()) {
            return
        }
        if (!isTermsAccepted.value) {
            Toast.makeText(context, "Please accept the terms and conditions", Toast.LENGTH_LONG)
                .show()
            return
        }
        if (!isAgeConfirmed.value) {
            Toast.makeText(context, "Please confirm your age", Toast.LENGTH_LONG).show()
            return
        }

        signupViewModel.signup(
            SignupRequestModel(
                above_thirteen = isAgeConfirmed.value,
                accept_term_condition = isTermsAccepted.value,
                email_address = emailAddress.value,
                password = password.value,
                confirm_password = confirmPassword.value
            )
        )
    }

    LaunchedEffect(signupState.value) {
        when (val state = signupState.value) {
            is NetworkResponse.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
                signupViewModel.resetSignupState()
            }

            is NetworkResponse.Success -> {
                Toast.makeText(context, state.data.message, Toast.LENGTH_LONG).show()
                navHostController.navigate(VerifyEmailOtp(email = emailAddress.value))
                signupViewModel.resetSignupState()
            }

            else -> {}
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
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.back_arrow_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(8.dp)
                    .clickable {
                        navHostController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(30.dp))
        CustomText(
            "Sign Up",
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

                    if (it.isBlank()) {
                        emailAddressError.value = "Email is required"
                    } else if (!it.matches(AppRegex.emailRegex)) {
                        emailAddressError.value = "Invalid email"
                    } else {
                        emailAddressError.value = ""
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
                placeholderText = "8 - 20 characters",
                leadingIcon = R.drawable.lock_icon,
                value = password.value,
                onValueChange = {
                    password.value = it

                    if (it.isBlank()) {
                        passwordError.value = "Password is required"
                    } else if (!it.matches(AppRegex.passwordRegex)) {
                        passwordError.value = "Password must match the criteria"
                    } else {
                        passwordError.value = ""
                    }
                },
                errorMessage = passwordError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Confirm Password",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "Enter your password again",
                leadingIcon = R.drawable.lock_icon,
                value = confirmPassword.value,
                onValueChange = {
                    confirmPassword.value = it

                    if (it.isBlank()) {
                        confirmPasswordError.value = "Confirm password is required"
                    } else if (it != password.value) {
                        confirmPasswordError.value = "Passwords do not match"
                    } else {
                        confirmPasswordError.value = ""
                    }
                },
                errorMessage = confirmPasswordError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            passwordConditions.forEach { text ->
                Column(modifier = Modifier.padding(vertical = 3.dp)) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(R.drawable.circle_checked_icon),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        CustomText(
                            text = text,
                            fontSize = 14,
                            fontWeight = FontWeight.Normal,
                            color = AppColors.Gray800
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (isTermsAccepted.value) {
                    Image(
                        painter = painterResource(R.drawable.rectangle_checked_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                isTermsAccepted.value = !isTermsAccepted.value
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.rectangle_unchecked_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                isTermsAccepted.value = !isTermsAccepted.value
                            }
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    buildAnnotatedString {
                        append("I have read the ")
                        withStyle(
                            style = SpanStyle(
                                color = AppColors.MidnightBlue,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Terms and Conditions")
                        }
                        append(" and ")
                        withStyle(
                            style = SpanStyle(
                                color = AppColors.MidnightBlue,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Privacy Policy")
                        }
                    }, style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.Gray700,
                    )
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (isAgeConfirmed.value) {
                    Image(
                        painter = painterResource(R.drawable.rectangle_checked_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                isAgeConfirmed.value = !isAgeConfirmed.value
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.rectangle_unchecked_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                isAgeConfirmed.value = !isAgeConfirmed.value
                            }
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                CustomText(
                    text = "I affirm I am 13 years old or older",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.Gray700
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            onClick = {
                signup()
            },
            text = "Verify",
            isLoading = signupState.value is NetworkResponse.Loading
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}
