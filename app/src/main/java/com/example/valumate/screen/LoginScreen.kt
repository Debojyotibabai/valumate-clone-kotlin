package com.example.valumate.screen

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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins
import com.example.valumate.viewmodel.AuthViewModel

@Composable
fun LoginScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {
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
                leadingIcon = R.drawable.mail_icon
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
                authViewModel.login()
            },
            text = "Login"
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
