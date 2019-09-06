package com.example.firstapp.stdio.weatherapp.services

import com.example.firstapp.stdio.weatherapp.model.WeatherRequest
import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("/weather")
    public fun getWeather() :Call<WeatherRequest>

}