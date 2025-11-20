package com.example.valumate.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors

@Composable
fun ResultsScreen(navHostController: NavHostController) {
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
        Spacer(modifier = Modifier.height(50.dp))
        CustomText(
            "Results",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "A valuation of the business identified as [business name] was made by ValuMateAI based on the information provided by [User First and Last Name].",
            fontSize = 14,
            fontWeight = FontWeight.Light,
            color = AppColors.Gray800,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "This valuation was performed using the Capital Access Model (CAM), a proprietary method for determining an opinion of value by projecting the structure of a successful acquisition under certain conditions.",
            fontSize = 14,
            fontWeight = FontWeight.Light,
            color = AppColors.Gray800,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(AppColors.Gray625)
                .padding(horizontal = 20.dp, vertical = 35.dp)
        ) {
            CustomText(
                text = "Estimated Range of Company Valuation",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.Gray875
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                text = "$1,425,000 - $1,575,000",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20,
                color = AppColors.MidnightBlue
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "Subject to Assumptions, limiting conditions and scope",
            color = AppColors.Gray800,
            fontSize = 12,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomButton(text = "Additional Details", onClick = {}, modifier = Modifier.width(230.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomButton(
                text = "Talk to an Expert",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {},
                modifier = Modifier.width(160.dp),
                fontSize = 15
            )
            CustomButton(
                text = "Growth Opportunities",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {},
                modifier = Modifier.width(190.dp),
                fontSize = 15
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(
            text = "Dashboard",
            backgroundColor = AppColors.Light,
            textColor = AppColors.MidnightBlue,
            onClick = {
                navHostController.popBackStack(MainRoutes.DASHBOARD, inclusive = false)
            },
            modifier = Modifier.width(230.dp)
        )
    }
}
