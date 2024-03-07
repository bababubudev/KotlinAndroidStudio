package com.example.learnandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { App() }
  }
}

@Preview
@Composable
fun App() {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = "homeScreen",
  ) {
    composable("homeScreen") { HomeScreen(navController) }
    composable("forecastByDate") { ForecastByDate(navController) }
  }
}