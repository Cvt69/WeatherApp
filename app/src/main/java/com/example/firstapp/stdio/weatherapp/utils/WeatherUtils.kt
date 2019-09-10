package com.example.firstapp.stdio.weatherapp.utils

import com.example.firstapp.stdio.weatherapp.R

class WeatherUtils {


    companion object {
        private val FORECAST_CLOUDY = "Cloudy"
        private val FORECAST_PARTLY_CLOUDY = "Partly cloudy"
        private val FORECAST_SUNNY = "Sunny"
        private val FORECAST_MOSTLY_CLOUDY = "Mostly cloudy"
        private val FORECAST_THUNDERSTORM = "Thunderstorm"
        private val FORECAST_SHOWERS = "Showers"
        private val FORECAST_RAIN = "Rain"

        fun loadWeatherIcon(forecast: String): Int {
            if (FORECAST_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_cloudy
            } else if (FORECAST_PARTLY_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_partlycloudy
            } else if (FORECAST_SUNNY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_sunny_week
            } else if (FORECAST_MOSTLY_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_mostlycloudy
            } else if (FORECAST_THUNDERSTORM.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_thunderstorm
            } else if (FORECAST_SHOWERS.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_showers
            } else if (FORECAST_RAIN.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_rain
            }

            return R.drawable.image_sunny


        }

        fun loadWeatherIconToday(forecast: String): Int {
            if (FORECAST_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_cloudy_today
            } else if (FORECAST_PARTLY_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_partlycloudy_today
            } else if (FORECAST_SUNNY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_sunny
            } else if (FORECAST_MOSTLY_CLOUDY.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_mostlycloudy_today
            } else if (FORECAST_THUNDERSTORM.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_thunderstorm_today
            } else if (FORECAST_SHOWERS.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_showers_today
            } else if (FORECAST_RAIN.toLowerCase().equals(forecast?.toLowerCase())) {
                return R.drawable.image_rain_today
            }

            return R.drawable.image_sunny


        }

    }
}