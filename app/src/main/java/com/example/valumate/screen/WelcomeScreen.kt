package com.example.valumate.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.valumate.R
import com.example.valumate.shared.CustomText
import com.example.valumate.ui.theme.AppColors

data class InwardCurvedTopShape(val dipDepth: Dp = 120.dp) : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val w = size.width
        val h = size.height
        val d = with(density) { dipDepth.toPx() }

        val path = Path().apply {
            moveTo(0f, 0f)
            quadraticBezierTo(w / 2f, d, w, 0f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        return Outline.Generic(path)
    }
}

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Light),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.logo_with_app_name),
            contentDescription = null,
            modifier = Modifier.width(325.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        val shape = InwardCurvedTopShape(dipDepth = 80.dp) // tweak to match your mock

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppColors.MidnightBlue, shape)
                .clip(shape)
                .padding(top = 75.dp, bottom = 30.dp, start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = "Business Valuation that Makes Sense",
                fontSize = 18,
                fontWeight = FontWeight.Medium,
                color = AppColors.Light
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.powered_by_aws),
                contentDescription = null,
                modifier = Modifier.width(141.dp)
            )
        }
    }
}
