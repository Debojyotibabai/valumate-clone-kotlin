package com.example.valumate.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.shared.CustomButton
import com.example.valumate.shared.CustomSelectDropdown
import com.example.valumate.shared.CustomText
import com.example.valumate.shared.CustomTextField
import com.example.valumate.ui.theme.AppColors

@Composable
fun EditProfileScreen(navHostController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
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
            "Edit your profile",
            fontSize = 32,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.MidnightBlue
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(R.drawable.no_avatar),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(
                        RoundedCornerShape(100.dp)
                    ),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(R.drawable.circle_plus_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .offset(y = (-10).dp),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.weight(1f)
                ) {
                    CustomText(
                        text = "First name *",
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.CharcoalBlack
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(placeholderText = "First name")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.weight(1f)
                ) {
                    CustomText(
                        text = "Last name *",
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.CharcoalBlack
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(placeholderText = "Last name")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
            ) {
                CustomText(
                    text = "Phone Number *",
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    color = AppColors.CharcoalBlack
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(placeholderText = "(123) 456 7890")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.weight(1f)
                ) {
                    CustomText(
                        text = "State",
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.CharcoalBlack
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomSelectDropdown(
                        items = listOf("Alabama", "Alaska", "Arizona"),
                        placeholderText = "Select state",
                        onItemSelected = {},
                        selectedItem = ""
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.weight(1f)
                ) {
                    CustomText(
                        text = "Zip Code",
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = AppColors.CharcoalBlack
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(placeholderText = "Zip code")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                text = "* Required",
                fontSize = 14,
                fontWeight = FontWeight.Medium,
                color = AppColors.MidnightBlue
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(text = "Save & Continue", onClick = {
            navHostController.popBackStack()
        })
        Spacer(modifier = Modifier.height(20.dp))
    }
}
