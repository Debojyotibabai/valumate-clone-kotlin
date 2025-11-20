package com.example.valumate.screen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.navigation.MainRoutes
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.ProfitAndLossReview
import com.example.valumate.ui.theme.AppColors
import kotlinx.coroutines.launch

@Composable
fun ReviewUploadScreen(navHostController: NavHostController) {
    val pages = arrayOf(
        "Most Recent Annual Profit & Loss Statement",
        "Most Recent Annual Balance Sheet ",
        "Other Expenses or Revenue",
        "other expenses",
        "Payments to Owner"
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
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
            "Review Upload",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(pages.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .size(20.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            if (index == pagerState.currentPage) AppColors.MidnightBlue else AppColors.Gray625
                        )
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                )
            }
        }
        Spacer(modifier = Modifier.height(35.dp))
        ProfitAndLossReview(
            pagerState = pagerState, title = pages[pagerState.currentPage], modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                text = "I verify that the numbers inputted match my statements",
                fontSize = 14,
                fontWeight = FontWeight.Normal,
                color = AppColors.Gray700
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(
            text = "Submit",
            backgroundColor = AppColors.Light,
            textColor = AppColors.MidnightBlue,
            onClick = {
                navHostController.navigate(MainRoutes.RESULTS)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}
