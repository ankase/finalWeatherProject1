package com.example.finalweatherproject

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    @GET("community-open-weather-map.p.rapidapi.com/weather")
    fun getWeather(): Call<WeatherData>
}