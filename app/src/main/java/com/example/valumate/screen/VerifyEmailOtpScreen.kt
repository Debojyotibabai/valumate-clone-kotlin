package com.example.valumate.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.model.VerifyOtpRequestModel
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomOtpTextField
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins
import com.example.valumate.utils.NetworkResponse
import com.example.valumate.viewmodel.VerifyOtpViewModel

@Composable
fun VerifyEmailOtpScreen(
    navHostController: NavHostController,
    email: String,
    verifyOtpViewModel: VerifyOtpViewModel = hiltViewModel()
) {
    val verifyOtpState = verifyOtpViewModel.verifyOtpState.collectAsStateWithLifecycle()

    val otp = remember { mutableStateOf("") }

    val context = LocalContext.current

    LaunchedEffect(verifyOtpState.value) {
        when (val verifyOtpStateValue = verifyOtpState.value) {
            is NetworkResponse.Error -> {
                Toast.makeText(context, verifyOtpStateValue.message, Toast.LENGTH_LONG).show()
                verifyOtpViewModel.resetVerifyOtpState()
            }

            is NetworkResponse.Success -> {
                Toast.makeText(context, verifyOtpStateValue.data.message, Toast.LENGTH_LONG).show()
                verifyOtpViewModel.resetVerifyOtpState()
                navHostController.navigate(MainRoutes.DASHBOARD)
            }

            else -> {}
        }
    }

    fun verifyOtp() {
        if (otp.value.length != 6) {
            Toast.makeText(context, "Please enter a valid 6-digit OTP", Toast.LENGTH_LONG).show()
            return
        }

        verifyOtpViewModel.verifyOtp(
            VerifyOtpRequestModel(email_address = email, verification_code = otp.value)
        )
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
            "Verify Your Email",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            "Please enter the 6 digit code sent to $email",
            fontSize = 14,
            fontWeight = FontWeight.Normal,
            color = AppColors.CharcoalBlack,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(35.dp))
        CustomOtpTextField(
            onChanged = { otpValue ->
                Log.d("VerifyEmailOtp", "OTP changed: '$otpValue', length: ${otpValue.length}")
                otp.value = otpValue
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            onClick = { verifyOtp() },
            text = "Verify",
            isLoading = verifyOtpState.value is NetworkResponse.Loading
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            buildAnnotatedString {
                append("Didn’t receive the code? ")
                withStyle(
                    style = SpanStyle(
                        color = AppColors.MidnightBlue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Resend")
                }
            }, style = TextStyle(
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = AppColors.Gray700,
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}
