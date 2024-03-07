package com.example.learnandroidcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ForecastByDate(navController: NavHostController) {
  val weatherForecasts = listOf<WeatherData>(
    WeatherData("MON", "Sunny", 20.2),
    WeatherData("TUE", "Cloudy", 10.1),
    WeatherData("WED", "Cloudy", 10.0),
    WeatherData("THU", "Overcast", 5.6),
    WeatherData("FRI", "Overcast", 0.5),
    WeatherData("SAT", "Snow",-1.1),
    WeatherData("SUN", "Snow",-5.1),
    WeatherData("THU", "Overcast", 5.6),
    WeatherData("FRI", "Cloudy", 0.5),
    WeatherData("SAT", "Snow",-1.1),
    WeatherData("SUN", "Snow",-5.1),
  )

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.DarkGray)
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Header("Tampere")

    Spacer(modifier = Modifier.padding(10.dp))

    LazyColumn(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1F)
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      items(weatherForecasts) {data -> WeatherListItemLayout(data)}
    }

    FilledTonalButton (
      onClick = { navController.navigate("homeScreen") },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = stringResource(R.string.menu_page_home), fontSize = 15.sp)
    }
  }
}

@Preview
@Composable
private fun PreviewForecast() {
  val tempNavController = rememberNavController()
  ForecastByDate(navController = tempNavController)
}