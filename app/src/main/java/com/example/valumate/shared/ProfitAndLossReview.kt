package com.example.valumate.shared

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.valumate.R
import com.example.valumate.ui.theme.AppColors

@Composable
fun ProfitAndLossReview(
    pagerState: PagerState,
    title: String,
    modifier: Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomText(
                    text = title,
                    color = AppColors.MidnightBlue,
                    fontSize = 20,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(R.drawable.edit_icon),
                    contentDescription = null,
                    modifier = Modifier.size(19.dp),
                    colorFilter = ColorFilter.tint(AppColors.MidnightBlue)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                Modifier,
                DividerDefaults.Thickness,
                color = AppColors.Gray625
            )
            repeat(10) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        CustomText(
                            text = "Profit/Loss, Ordinary Business Income",
                            color = AppColors.Gray800,
                            fontSize = 14,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                        CustomText(
                            text = "$1,200,000",
                            color = AppColors.Gray800,
                            fontSize = 14,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    HorizontalDivider(
                        Modifier,
                        DividerDefaults.Thickness,
                        color = AppColors.Gray625
                    )
                }
            }
        }
    }
}
