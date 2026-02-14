package com.example.valumate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.valumate.screen.WelcomeScreen
import com.example.valumate.utils.DataStoreManager
import kotlinx.coroutines.delay

@Composable
fun MainNavigation(dataStoreManager: DataStoreManager) {
    val navController: NavHostController = rememberNavController()

    val showWelcome = remember { mutableStateOf(true) }

    val accessToken = dataStoreManager.accessToken.collectAsState(initial = null).value

    LaunchedEffect(Unit) {
        delay(3000)
        showWelcome.value = false
    }

    if (showWelcome.value) {
        WelcomeScreen(navController)
    } else if (accessToken == null) {
        AuthNavigation(navController)
    } else {
        AppNavigation(navController)
    }
}
