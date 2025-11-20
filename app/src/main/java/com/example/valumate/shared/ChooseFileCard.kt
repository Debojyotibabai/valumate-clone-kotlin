package com.example.valumate.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.valumate.ui.theme.AppColors

@Composable
fun ChooseFileCard(text: String, isFileChosen: Boolean = false) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isFileChosen) AppColors.MidnightBlue else AppColors.Light,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if (isFileChosen) AppColors.MidnightBlue else AppColors.Gray625,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    color = if (isFileChosen) AppColors.Light else AppColors.Gray600,
                    shape = RoundedCornerShape(2.dp)
                )
                .border(
                    width = 1.dp,
                    color = if (isFileChosen) AppColors.MidnightBlue else AppColors.Gray650,
                    shape = RoundedCornerShape(2.dp)
                )
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            CustomText(
                text = if (isFileChosen) "Change File" else "Choose File",
                fontWeight = FontWeight.Normal,
                fontSize = 12,
                color = if (isFileChosen) AppColors.MidnightBlue else AppColors.CharcoalBlack
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        CustomText(
            text = if (isFileChosen) text else "No file chosen",
            fontWeight = FontWeight.Normal,
            fontSize = 14,
            color = if (isFileChosen) AppColors.Light else AppColors.CharcoalBlack,
            textAlign = TextAlign.Center
        )
    }
}
