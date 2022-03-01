package com.example.finalweatherproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalweatherproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rapidapi.com/")
            .build()

        val service = retrofit.create(WeatherApi::class.java)
        service.getWeather().enqueue(object: Callback<WeatherData>{
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                println("!!! ${response.body()}")
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                t.printStackTrace()
            }
        })

        Executors.newSingleThreadExecutor().execute {
            val url = URL("https://community-open-weather-map.p.rapidapi.com/weather")
            val connection = url.openConnection() as HttpURLConnection
            try{
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val line = br.readLine()
                println("!!! $line")
            } finally {
                connection.disconnect()
            }
        }
    }
}


