package com.example.valumate.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.valumate.R
import com.example.valumate.ui.theme.AppColors

@Composable
fun ValuationCard(isCompleted: Boolean) {
    Column {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(
                    AppColors.Light
                )
                .padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomText(
                    text = "Business Name 2026",
                    fontSize = 16,
                    fontWeight = FontWeight.Medium,
                    color = AppColors.CharcoalBlack,
                    modifier = Modifier.weight(1f)
                )
                CustomText(text = "09/02/2026", fontSize = 14, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.edit_icon),
                    contentDescription = null,
                    modifier = Modifier.size(19.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            CustomText(text = "Status", fontSize = 12, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(10.dp))
            if (isCompleted) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            AppColors.PaleMintGreen
                        )
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.complete_icon),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomText(
                        text = "Complete",
                        fontSize = 10,
                        fontWeight = FontWeight.Medium,
                        color = AppColors.ForestGreen
                    )
                }

            } else {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            AppColors.Gray600
                        )
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.draft_icon),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomText(text = "Draft", fontSize = 10, fontWeight = FontWeight.Medium)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}
