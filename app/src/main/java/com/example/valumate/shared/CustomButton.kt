package com.example.valumate.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.valumate.ui.theme.AppColors

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    backgroundColor: Color = AppColors.MidnightBlue,
    textColor: Color = AppColors.Light,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.SemiBold,
    isLoading: Boolean = false,
    isDisabled: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth(),
    textAlign: TextAlign = TextAlign.Center
) {
    val shape = RoundedCornerShape(8.dp)

    Button(
        onClick = onClick.takeIf { !isLoading && !isDisabled } ?: {},
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 12.dp),
        modifier = modifier
            .border(
                BorderStroke(
                    width = 1.5.dp,
                    color = if (textColor != AppColors.Light) textColor else Color.Transparent
                ),
                shape = shape
            )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = textColor,
                    strokeWidth = 2.5.dp,
                    modifier = Modifier.size(22.dp)
                )
            } else {
                CustomText(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = textColor,
                    textAlign = textAlign
                )
            }
        }
    }
}
