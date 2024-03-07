package com.example.learnandroidcompose

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherDataComponent(weatherValue: String, weatherImage: Painter, weatherName: String) {
  // Module for a weather event
  Row (
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom
  ) {
    Text(text = weatherValue, color = Color.White, fontSize = 20.sp)
    Image(painter = weatherImage, contentDescription = "weather image", modifier = Modifier.size(50.dp))
  }

  Divider(modifier = Modifier
    .padding(8.dp, 10.dp, 8.dp, 5.dp)
  )

  Text(
    text = weatherName,
    color = Color.White,
    fontSize = 20.sp,
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    textAlign = TextAlign.End
  )
}
