package com.example.valumate.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors

@Composable
fun ChooseInputMethodScreen(navHostController: NavHostController) {
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
            "How Would You Like to Proceed?",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomText(
            text = "Choose to upload your financial documents (Preferred) or  enter data manually.",
            fontSize = 14,
            fontWeight = FontWeight.Normal,
            color = AppColors.CharcoalBlack,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(45.dp))
        CustomButton(text = "Upload Documents", onClick = {
            navHostController.navigate(MainRoutes.UPLOAD_CHECKLIST)
        })
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(
            text = "Enter Manually",
            backgroundColor = AppColors.Light,
            textColor = AppColors.MidnightBlue,
            onClick = {
                navHostController.navigate(MainRoutes.MANUAL_UPLOAD_CHECKLIST)
            })
        Spacer(modifier = Modifier.height(20.dp))
    }
}
