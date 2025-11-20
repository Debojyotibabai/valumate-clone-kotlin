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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors

@Composable
fun OtherExpensesScreen(navHostController: NavHostController) {
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
                        navHostController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(30.dp))
        CustomText(
            "Other Expenses or Revenue",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "Use this section to identify revenue or expenses on the Profit & Loss that aren’t related to the business being valued. For valuation purposes, these items should be clearly identifiable in itemized financial statements.",
            fontSize = 14,
            fontWeight = FontWeight.Light,
            color = AppColors.Gray800,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomText(
                "Description",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "e.g. Rental Property Revenue"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Amount ($)",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "",
                leadingIcon = R.drawable.dollar_icon,
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Why should this be included?",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "Other expenses are one-time expenses that should be added back.",
                minLines = 4
            )
            Spacer(modifier = Modifier.height(40.dp))
            CustomButton(
                text = "Add Another",
                backgroundColor = AppColors.Light,
                textColor = AppColors.MidnightBlue,
                onClick = {})
            Spacer(modifier = Modifier.height(10.dp))
            CustomButton(
                onClick = {
                    navHostController.popBackStack()
                },
                text = "Continue"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
