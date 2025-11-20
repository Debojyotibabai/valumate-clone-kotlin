package com.example.valumate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valumate.screen.AboutBusinessScreen
import com.example.valumate.screen.AssetFormScreen
import com.example.valumate.screen.BusinessLinksScreen
import com.example.valumate.screen.ChooseInputMethodScreen
import com.example.valumate.screen.CreateProfileScreen
import com.example.valumate.screen.DashboardScreen
import com.example.valumate.screen.EditProfileScreen
import com.example.valumate.screen.ManualBalanceSheetScreen
import com.example.valumate.screen.ManualProfitLossScreen
import com.example.valumate.screen.ManualUploadChecklistScreen
import com.example.valumate.screen.OtherExpensesScreen
import com.example.valumate.screen.PaymentsToOwnerScreen
import com.example.valumate.screen.PurposeFormScreen
import com.example.valumate.screen.ResultsScreen
import com.example.valumate.screen.ReviewUploadScreen
import com.example.valumate.screen.SettingsScreen
import com.example.valumate.screen.UploadChecklistScreen
import com.example.valumate.screen.ViewProfileScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainRoutes.DASHBOARD) {
        composable(MainRoutes.ABOUT_BUSINESS) {
            AboutBusinessScreen(navHostController)
        }
        composable(MainRoutes.ASSET_FORM) {
            AssetFormScreen(navHostController)
        }
        composable(MainRoutes.BUSINESS_LINKS) {
            BusinessLinksScreen(navHostController)
        }
        composable(MainRoutes.CHOOSE_INPUT_METHOD) {
            ChooseInputMethodScreen(navHostController)
        }
        composable(MainRoutes.CREATE_PROFILE) {
            CreateProfileScreen(navHostController)
        }
        composable(MainRoutes.DASHBOARD) {
            DashboardScreen(navHostController)
        }
        composable(MainRoutes.EDIT_PROFILE) {
            EditProfileScreen(navHostController)
        }
        composable(MainRoutes.MANUAL_BALANCE_SHEET) {
            ManualBalanceSheetScreen(navHostController)
        }
        composable(MainRoutes.MANUAL_PROFIT_LOSS) {
            ManualProfitLossScreen(navHostController)
        }
        composable(MainRoutes.MANUAL_UPLOAD_CHECKLIST) {
            ManualUploadChecklistScreen(navHostController)
        }
        composable(MainRoutes.OTHER_EXPENSES) {
            OtherExpensesScreen(navHostController)
        }
        composable(MainRoutes.PAYMENTS_TO_OWNER) {
            PaymentsToOwnerScreen(navHostController)
        }
        composable(MainRoutes.PURPOSE_FORM) {
            PurposeFormScreen(navHostController)
        }
        composable(MainRoutes.RESULTS) {
            ResultsScreen(navHostController)
        }
        composable(MainRoutes.REVIEW_UPLOAD) {
            ReviewUploadScreen(navHostController)
        }
        composable(MainRoutes.SETTINGS) {
            SettingsScreen(navHostController)
        }
        composable(MainRoutes.UPLOAD_CHECKLIST) {
            UploadChecklistScreen(navHostController)
        }
        composable(MainRoutes.VIEW_PROFILE) {
            ViewProfileScreen(navHostController)
        }
    }
}
