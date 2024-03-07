package com.example.learnandroidcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(headerText: String) {
  Text(
    text = headerText,
    fontSize = 50.sp,
    textAlign = TextAlign.Center,
    color = Color.White,
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 0.dp, vertical = 10.dp)
  )
}