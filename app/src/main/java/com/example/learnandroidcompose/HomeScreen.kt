package com.example.learnandroidcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.DarkGray)
      .padding(16.dp),
  )
  {
    Header("Tampere")
    Spacer(modifier = Modifier.padding(25.dp))

    // Weather component module containing value,
    // image of weather type, and name of weather type
    // including localizations.
    WeatherDataComponent(
      "20 °C",
      painterResource(id = R.drawable.sunny),
      weatherName = stringResource(R.string.weather_sunny)
    )

    Spacer(modifier = Modifier.padding(vertical = 30.dp))

    WeatherDataComponent(
      weatherValue = "6 m/s " + stringResource(R.string.weather_wind_dir),
      painterResource(id = R.drawable.breeze),
      weatherName = stringResource(R.string.weather_wind_low),
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

@Preview
@Composable
private fun PreviewHome() {
  val tempNavController = rememberNavController()
  HomeScreen(navController = tempNavController)
}