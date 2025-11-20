package com.example.valumate.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.ChooseFileCard
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors

@Composable
fun UploadChecklistScreen(navHostController: NavHostController) {
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
        CustomText(
            "Document Checklist",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(AppColors.MidnightBlue)
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomText(
            text = "50% Completed",
            fontSize = 16,
            fontWeight = FontWeight.Normal,
            color = AppColors.CharcoalBlack,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        LinearProgressIndicator(
            progress = { 0.5f },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp),
            color = AppColors.MintGreen,
            trackColor = AppColors.Gray650
        )
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            CustomText(
                "Most Recent Annual Profit & Loss Statement",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChooseFileCard(text = "ProfitLossStatement2024.pdf", isFileChosen = true)
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Most Recent Balance Sheet",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            ChooseFileCard(text = "BalanceSheet2024.pdf", isFileChosen = false)
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Correlation to Current Performance",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "Explain how this year’s performance compares to previous periods...",
                minLines = 5,
                bordered = true
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Assets",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomButton(
                text = "Add Assets",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {
                    navHostController.navigate(MainRoutes.ASSET_FORM)
                },
                fontWeight = FontWeight.Normal,
                fontSize = 14
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Other Expenses or Revenue",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomButton(
                text = "Add Other Expenses or Revenue",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {
                    navHostController.navigate(MainRoutes.OTHER_EXPENSES)
                },
                fontWeight = FontWeight.Normal,
                fontSize = 14
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(
                "Payments to Owner",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomButton(
                text = "Add Payment to Owner",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {
                    navHostController.navigate(MainRoutes.PAYMENTS_TO_OWNER)
                },
                fontWeight = FontWeight.Normal,
                fontSize = 14
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            onClick = {
                navHostController.navigate(MainRoutes.REVIEW_UPLOAD)
            },
            text = "Continue"
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}
