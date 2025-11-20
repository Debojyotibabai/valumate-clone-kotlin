package com.example.valumate.screen

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors

@Composable
fun BusinessLinksScreen(navHostController: NavHostController) {
    BackHandler {
        navHostController.popBackStack(MainRoutes.DASHBOARD, inclusive = false)
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
                        navHostController.popBackStack(MainRoutes.DASHBOARD, inclusive = false)
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.Light)
                .padding(horizontal = 20.dp, vertical = 35.dp)
        ) {
            CustomText(
                "Business Links",
                fontSize = 22,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.MidnightBlue
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomText(
                    "Business Website",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "www.business.com",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomText(
                    "Business Social Media links",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "LinkedIn Link",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "Facebook Link",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "Instagram Link",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "X Link",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "YouTube Link",
                    bordered = true
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            CustomButton(text = "Continue", onClick = {
                navHostController.navigate(MainRoutes.PURPOSE_FORM)
            })
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
