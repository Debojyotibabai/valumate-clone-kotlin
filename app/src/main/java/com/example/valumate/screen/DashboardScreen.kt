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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.ValuationCard
import com.example.valumate.ui.theme.AppColors

@Composable
fun DashboardScreen(navHostController: NavHostController) {
    Scaffold(
        containerColor = AppColors.Gray600,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    CustomText(
                        text = "No valuations yet.",
                        fontSize = 16,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.weight(0.3f))
                    Image(
                        painter = painterResource(R.drawable.indicator),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(85.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    onClick = {
                        navHostController.navigate(MainRoutes.ABOUT_BUSINESS)
                    },
                    text = "Add Another Valuation"
                )
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.settings_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .clickable {
                            navHostController.navigate(MainRoutes.SETTINGS)
                        }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            CustomText(
                "Dashboard",
                fontSize = 32,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.MidnightBlue
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                repeat(2) { index ->
                    if (index % 2 == 0) {
                        ValuationCard(isCompleted = false)
                    } else {
                        ValuationCard(isCompleted = true)
                    }
                }
            }
        }
    }
}
