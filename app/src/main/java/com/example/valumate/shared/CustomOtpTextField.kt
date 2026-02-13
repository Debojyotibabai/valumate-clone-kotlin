package com.example.valumate.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalFocusManager
import com.example.valumate.ui.theme.AppColors

@Composable
fun CustomOtpTextField(
    count: Int = 6,
    boxSize: Dp = 53.dp,
    boxSpacing: Dp = 7.dp,
    onCompleted: ((String) -> Unit)? = null,
    onChanged: ((String) -> Unit)? = null
) {
    val focusManager = LocalFocusManager.current
    val values =
        remember(count) { mutableStateListOf<String>().apply { repeat(count) { add("") } } }
    val focusRequesters = remember(count) { List(count) { FocusRequester() } }
    val isFocused =
        remember(count) { mutableStateListOf<Boolean>().apply { repeat(count) { add(false) } } }

    LaunchedEffect(values.toList()) {
        val otp = values.joinToString("")
        onChanged?.invoke(otp)
        if (otp.length == count && values.all { it.isNotEmpty() }) {
            onCompleted?.invoke(otp)
            focusManager.clearFocus(force = true)
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(boxSpacing, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in 0 until count) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(boxSize)
                    .background(AppColors.Light, RoundedCornerShape(8.dp))
                    .border(
                        width = 1.dp,
                        color = if (isFocused.getOrNull(i) == true) AppColors.SteelBlue else AppColors.Gray700.copy(
                            alpha = 0.4f
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { focusRequesters[i].requestFocus() }
            ) {
                BasicTextField(
                    value = values[i],
                    onValueChange = { input ->
                        val digits = input.filter { it.isDigit() }
                        if (digits.isEmpty()) {
                            values[i] = ""
                        } else {
                            // Always keep only the last typed digit in this box
                            values[i] = digits.last().toString()
                            // Move focus forward when filled
                            if (i < count - 1) {
                                focusRequesters[i + 1].requestFocus()
                            } else {
                                // Last box filled -> clear keyboard/focus immediately
                                focusManager.clearFocus(force = true)
                            }
                        }
                    },
                    singleLine = true,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = AppColors.Gray900,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .focusRequester(focusRequesters[i])
                        .onFocusChanged { f ->
                            isFocused[i] = f.isFocused
                        }
                        .onKeyEvent { event ->
                            if (event.key == Key.Backspace && event.type == KeyEventType.KeyUp) {
                                if (values[i].isEmpty() && i > 0) {
                                    focusRequesters[i - 1].requestFocus()
                                }
                            }
                            false
                        },
                    decorationBox = { innerField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (values[i].isEmpty()) {
                                Text(
                                    text = "-",
                                    color = AppColors.Gray650,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center
                                )
                            }
                            innerField()
                        }
                    }
                )
            }
        }
    }
}
