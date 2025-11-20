package com.example.valumate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.valumate.screen.WelcomeScreen
import com.example.valumate.viewmodel.AuthViewModel
import kotlinx.coroutines.delay

@Composable
fun MainNavigation(authViewModel: AuthViewModel = hiltViewModel()) {
    val isLoggedIn = authViewModel.isLoggedIn.collectAsState()

    val navController: NavHostController = rememberNavController()

    val showWelcome = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        showWelcome.value = false
    }

    if (showWelcome.value) {
        WelcomeScreen(navController)
    } else {
        if (isLoggedIn.value) {
            AppNavigation(navController, authViewModel)
        } else {
            AuthNavigation(navController, authViewModel)
        }
    }
}
