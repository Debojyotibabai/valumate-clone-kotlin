package com.example.valumate.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomOtpTextField
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins

@Composable
fun VerifyEmailOtpScreen(navHostController: NavHostController) {
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
            "Please enter the 6 digit code sent to email@example.com",
            fontSize = 14,
            fontWeight = FontWeight.Normal,
            color = AppColors.CharcoalBlack,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(35.dp))
        CustomOtpTextField()
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            onClick = {
                navHostController.popBackStack(MainRoutes.LOGIN, inclusive = false)
            },
            text = "Verify"
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
