package com.example.valumate.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.valumate.ui.theme.AppColors

@Composable
fun CustomTextField(
    leadingIcon: Int? = null,
    placeholderText: String,
    bordered: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1,
    value: String = "",
    onValueChange: (String) -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isFocused) 1.dp else 0.dp,
                color = if (isFocused) {
                    AppColors.SteelBlue
                } else {
                    if (bordered) {
                        AppColors.Gray625
                    } else {
                        Color.Transparent
                    }
                },
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        if (leadingIcon != null) {
            OutlinedTextField(
                value = value,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),
                minLines = minLines,
                onValueChange = onValueChange,
                placeholder = {
                    CustomText(
                        placeholderText,
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.Gray700
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = AppColors.Light,
                    focusedContainerColor = AppColors.Light,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                interactionSource = interactionSource,
                leadingIcon = {
                    Image(
                        painter = painterResource(leadingIcon),
                        contentDescription = null,
                        modifier = Modifier.width(16.dp)
                    )
                }
            )
        } else {
            OutlinedTextField(
                value = value,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = keyboardType
                ),
                minLines = minLines,
                onValueChange = onValueChange,
                placeholder = {
                    CustomText(
                        placeholderText,
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.Gray700
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = AppColors.Light,
                    focusedContainerColor = AppColors.Light,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                interactionSource = interactionSource,
            )
        }
    }
}
