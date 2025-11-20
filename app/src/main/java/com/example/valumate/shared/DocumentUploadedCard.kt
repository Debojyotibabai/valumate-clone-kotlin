package com.example.valumate.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.valumate.R
import com.example.valumate.ui.theme.AppColors

@Composable
fun DocumentUploadedCard(text: String, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = AppColors.Light,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = AppColors.Gray625,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(15.dp)
            .clickable {
                onClick()
            }
    ) {
        Image(
            painter = painterResource(R.drawable.rectangle_checked_icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        CustomText(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 14,
            color = AppColors.MidnightBlue,
            textAlign = TextAlign.Center
        )
    }
}
