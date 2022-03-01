package com.example.finalweatherproject

data class WeatherData(
    val callback: String,
    val id: String,
    val lang: String,
    val lat: String,
    val lon: String,
    val mode: String,
    val q: String,
    val units: String
)