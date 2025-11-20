package com.example.valumate.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.viewmodel.AuthViewModel

@Composable
fun SettingsScreen(navHostController: NavHostController, authViewModel: AuthViewModel) {
    val settingsOptions = arrayOf(
        "My Profile",
        "Contact Us",
        "Privacy Policy",
        "Terms and Conditions",
        "Additional Disclaimers"
    )

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
            "Setting",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.Light)
                .padding(20.dp)
        ) {
            settingsOptions.forEachIndexed { index, it ->
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (index == 0) {
                                    navHostController.navigate(MainRoutes.VIEW_PROFILE)
                                }
                            }
                    ) {
                        CustomText(
                            text = it,
                            fontSize = 14,
                            color = AppColors.CharcoalBlack,
                            fontWeight = FontWeight.Normal
                        )
                        Image(
                            painter = painterResource(R.drawable.right_arrow_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(16.dp)
                                .padding(start = 10.dp)
                        )
                    }
                    if (index < settingsOptions.size - 1) {
                        Spacer(modifier = Modifier.height(15.dp))
                        HorizontalDivider(
                            Modifier,
                            DividerDefaults.Thickness,
                            color = AppColors.Gray625
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(
            text = "Log out",
            backgroundColor = AppColors.Light,
            textColor = AppColors.MidnightBlue,
            onClick = {
                authViewModel.logout()
            })
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(text = "Delete Account", onClick = {
            authViewModel.logout()
        })
    }
}
