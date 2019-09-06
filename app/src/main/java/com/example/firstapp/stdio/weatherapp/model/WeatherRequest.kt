package com.example.firstapp.stdio.weatherapp.model

import com.google.gson.annotations.SerializedName
import java.util.List

class WeatherRequest(
    @SerializedName("week-forecast") var weekForecast: List<WeatherModel>,
    var today: WeatherModel,
    var tomorrow: WeatherModel
) {
}