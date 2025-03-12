package com.example.compose_player_service

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sh(height: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun Sw(width: Dp = 10.dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun WhiteText(
    text: String = "text",
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(text, color = Color.White, fontSize = fontSize, fontWeight = fontWeight, modifier = modifier)
}