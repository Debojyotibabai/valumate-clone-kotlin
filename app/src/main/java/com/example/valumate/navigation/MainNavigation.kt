package com.example.valumate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.valumate.screen.WelcomeScreen
import kotlinx.coroutines.delay

@Composable
fun MainNavigation() {

    val navController: NavHostController = rememberNavController()

    val showWelcome = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        showWelcome.value = false
    }

    if (showWelcome.value) {
        WelcomeScreen(navController)
    } else {
        AuthNavigation(navController)
    }
}
