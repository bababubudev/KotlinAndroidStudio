package com.example.learnandroidcompose

import android.os.Bundle
import android.util.Log.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnandroidcompose.BuildConfig.API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { App() }
  }
}

interface APIService {
  @GET("weather")
  suspend fun fetchWeather(
    @Query("q") city: String,
    @Query("units") lon: String,
    @Query("appid") apiKey: String
  ): WeatherResponse
}

object RetrofitInstance {
  private var BASE_URL = "https://api.openweathermap.org/data/2.5/"
  private val retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val apiService : APIService by lazy {
    retrofit.create(APIService::class.java)
  }
}

@Composable
fun App() {
  val navController = rememberNavController()
  val retrofitInstance = RetrofitInstance.apiService
  var currentWeather by remember { mutableStateOf<WeatherResponse?>(null) }

  LaunchedEffect(Unit) {
    currentWeather = retrofitInstance.fetchWeather("tampere", "metric", API_KEY)
  }

  NavHost(
    navController = navController,
    startDestination = "homeScreen",
  ) {
    composable("homeScreen") { HomeScreen(navController, currentWeather) }
    composable("forecastByDate") { ForecastByDate(navController) }
  }
}