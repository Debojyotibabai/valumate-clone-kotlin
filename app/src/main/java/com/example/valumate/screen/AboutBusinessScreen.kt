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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors

@Composable
fun AboutBusinessScreen(navHostController: NavHostController) {
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
                "About Your Business",
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
                    "Business Name",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "e.g., Retail, Tech, Manufacturing",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomText(
                    "Business Address",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "000 South 999 North",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(R.drawable.rectangle_unchecked_icon),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomText(
                        text = "I have multiple business locations",
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.Gray700
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomText(
                    "Search NAICS Code",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "561730 – Landscaping Services",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomText(
                    "What industry is the business in?",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "e.g., Retail, Tech, Manufacturing",
                    bordered = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomText(
                    "How long have you owned the business?",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    placeholderText = "Enter the number of years",
                    bordered = true,
                    keyboardType = KeyboardType.Number
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            CustomButton(text = "Continue", onClick = {
                navHostController.navigate(MainRoutes.BUSINESS_LINKS)
            })
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
