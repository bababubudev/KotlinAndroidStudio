package com.example.learnandroidcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun WeatherListItemLayout(
  day: String = "MON",
  weatherType: String = "Snow",
  value: String = "20.2 °C"
) {

  Row (
    modifier = Modifier.padding(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = day,
      fontSize = 24.sp,
      color = Color.White,
    )

    Spacer(modifier = Modifier.weight(1F))

    val image = getImageResource(description = weatherType)
    if (image != null) {
      Image(
        painter = image,
        contentDescription = weatherType,
        modifier = Modifier.size(40.dp)
      )
      Spacer(modifier = Modifier.padding(10.dp))
    }

    Column (
      modifier = Modifier.width(90.dp),
      horizontalAlignment = Alignment.End
    ) {
      Text(text = weatherType, fontSize = 18.sp, color = Color.White)
      Text(text = value, fontSize = 18.sp, color = Color.White)
    }
  }
}

@Composable
fun WeatherListItemLayout(data: WeatherData) {
  WeatherListItemLayout(
    data.day,
    data.description,
    "${data.temperature} °C"
  );
}

@Composable
fun getImageResource(description: String): Painter? {
  return when (description) {
    "Sunny" -> painterResource(id = R.drawable.sunny)
    "Cloudy" -> painterResource(id = R.drawable.cloud)
    "Overcast" -> painterResource(id = R.drawable.overcast)
    "Snow" -> painterResource(id = R.drawable.snowflake)
    else  -> null;
  };
}
