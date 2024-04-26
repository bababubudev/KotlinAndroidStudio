package com.example.learnandroidcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.math.round

@Composable
fun HomeScreen(navController: NavHostController, currentWeather: WeatherResponse?, onSearchSubmit: (String) -> Unit) {
  var currentText by remember { mutableStateOf("") }
  val customShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp, bottomStart = 8.dp, bottomEnd = 8.dp)

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.DarkGray)
      .padding(16.dp),
  )
  {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      TextField(
        value = currentText,
        onValueChange = { currentText = it },
        label = {Text(text = "Search for cities")},
        modifier = Modifier.weight(0.7f),
        shape = customShape
      )
      Button(
        modifier = Modifier.weight(0.3f).padding(start=5.dp),
        onClick = { onSearchSubmit(currentText) },
        shape = customShape
      ) {
        Text(text = "Search", Modifier.padding(vertical=10.dp))
      }
    }

    Spacer(modifier = Modifier.padding(20.dp))

    Header(currentWeather?.name?: "Loading...")

    Spacer(modifier = Modifier.padding(20.dp))

    // Weather component module containing value,
    // image of weather type, and name of weather type
    // including localizations.
    WeatherDataComponent(
      (currentWeather?.main?.temp?.let { round(it).toInt().toString() } + " °C")?:"...",
      painterResource(id = R.drawable.sunny),
      weatherName = currentWeather?.weather?.get(0)?.main?:"..."
    )

    Spacer(modifier = Modifier.padding(vertical = 30.dp))

    WeatherDataComponent(
      weatherValue = (currentWeather?.wind?.speed?.toString() + " m/s")?:"...",
      painterResource(id = R.drawable.breeze),
      weatherName = (currentWeather?.wind?.deg?.toString() + " ° from North")?:"...",
    )

    Spacer(modifier = Modifier.weight(1F))

    FilledTonalButton(
      onClick = { navController.navigate("forecastByDate") },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = stringResource(R.string.menu_page_more),
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
      )
    }
  }
}

/*
@Preview
@Composable
private fun PreviewHome() {
  val tempNavController = rememberNavController()
  HomeScreen(navController = tempNavController, null)
}
*/