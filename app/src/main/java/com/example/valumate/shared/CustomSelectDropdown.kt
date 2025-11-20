package com.example.valumate.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.valumate.R
import com.example.valumate.ui.theme.AppColors

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomSelectDropdown(
    items: List<String>,
    selectedItem: String?,
    onItemSelected: (String) -> Unit,
    placeholderText: String,
    leadingIcon: Int? = null,
) {
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isFocused || expanded) 1.dp else 0.dp,
                color = if (isFocused || expanded) AppColors.SteelBlue else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedItem ?: "",
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    CustomText(
                        placeholderText,
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.Gray700
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = AppColors.Light,
                    focusedContainerColor = AppColors.Light,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                interactionSource = interactionSource,
                leadingIcon = if (leadingIcon != null) {
                    {
                        Image(
                            painter = painterResource(leadingIcon),
                            contentDescription = null,
                            modifier = Modifier.width(16.dp)
                        )
                    }
                } else null,
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.down_arrow_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .width(11.dp)
                            .height(6.dp)
                    )
                }
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(AppColors.Light)
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            CustomText(
                                item,
                                fontSize = 14,
                                fontWeight = FontWeight.Normal,
                                color = AppColors.Gray900
                            )
                        },
                        onClick = {
                            onItemSelected(item)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
