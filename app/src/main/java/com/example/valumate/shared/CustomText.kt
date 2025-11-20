package com.example.valumate.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.valumate.ui.theme.AppColors
import com.example.valumate.ui.theme.Poppins

@Composable
fun CustomText(
    text: String,
    color: Color = AppColors.Dark,
    fontSize: Int,
    fontWeight: FontWeight,
    textAlign: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        textAlign = textAlign,
        modifier = modifier,
        style = TextStyle(
            color = color,
            fontSize = fontSize.sp,
            fontFamily = Poppins,
            fontWeight = fontWeight
        )
    )
}
