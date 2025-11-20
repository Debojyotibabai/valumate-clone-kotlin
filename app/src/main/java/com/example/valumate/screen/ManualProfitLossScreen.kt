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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomSelectDropdown
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins

@Composable
fun ManualProfitLossScreen(navHostController: NavHostController) {
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
            "Profit & Loss Statement",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "Please add your most recent annual data",
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
                "Gross Revenue",
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
                "Cost of Goods Sold",
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
                "Gross Profit",
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
                "Expenses",
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
                "Profit/Loss, Ordinary Business Income",
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
                "Are these numbers from current or last fiscal year?",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomSelectDropdown(
                items = listOf("Current", "Previous"),
                selectedItem = "",
                placeholderText = "Select",
                onItemSelected = {}
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "How does current revenue compare to prior fiscal year?",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomSelectDropdown(
                items = listOf("Worse", "Better", "Same"),
                selectedItem = "",
                placeholderText = "Select",
                onItemSelected = {}
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Please elaborate on revenue change:",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "e.g. Launched new product line...",
                minLines = 4
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Add the Percentage of change",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "25%",
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Estimates year end sales: $0", style = TextStyle(
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = AppColors.CharcoalBlack,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "How does current profit/loss compare to prior fiscal year?",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomSelectDropdown(
                items = listOf("Worse", "Better", "Same"),
                selectedItem = "",
                placeholderText = "Select",
                onItemSelected = {}
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Please elaborate on profit/loss change:",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.CharcoalBlack
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(
                placeholderText = "e.g. Reduced overhead costs...",
                minLines = 4
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                "Interest Expense",
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
                "Depreciation",
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
            Spacer(modifier = Modifier.height(40.dp))
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
