package com.example.valumate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.valumate.navigation.typeSafeRoutes.VerifyEmailOtp
import com.example.valumate.screen.ForgotPasswordScreen
import com.example.valumate.screen.LoginScreen
import com.example.valumate.screen.ResetPasswordOtpScreen
import com.example.valumate.screen.ResetPasswordScreen
import com.example.valumate.screen.SignupScreen
import com.example.valumate.screen.VerifyEmailOtpScreen

@Composable
fun AuthNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainRoutes.LOGIN) {
        composable(MainRoutes.LOGIN) {
            LoginScreen(navHostController)
        }
        composable(MainRoutes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(navHostController)
        }
        composable(MainRoutes.RESET_PASSWORD_OTP) {
            ResetPasswordOtpScreen(navHostController)
        }
        composable(MainRoutes.RESET_PASSWORD) {
            ResetPasswordScreen(navHostController)
        }
        composable(MainRoutes.SIGNUP) {
            SignupScreen(navHostController)
        }
        composable<VerifyEmailOtp> { backStackEntry ->
            val email = backStackEntry.toRoute<VerifyEmailOtp>().email
            VerifyEmailOtpScreen(navHostController, email = email)
        }
    }
}
