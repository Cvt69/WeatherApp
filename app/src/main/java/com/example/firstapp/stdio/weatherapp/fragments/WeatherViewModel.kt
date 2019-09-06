package com.example.firstapp.stdio.weatherapp.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.stdio.weatherapp.model.WeatherRequest
import com.example.firstapp.stdio.weatherapp.services.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherViewModel : ViewModel() {

    private val VIEWMODELKEY = "WeatherViewModel"
    private var weatherService = Retrofit.Builder().baseUrl("http://challenge001.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(WeatherService::class.java)
    var weather = MutableLiveData<WeatherRequest>()

    public fun loadWeather() {

        weatherService.getWeather().enqueue(object : Callback<WeatherRequest?> {
            override fun onFailure(call: Call<WeatherRequest?>, t: Throwable) {
                Log.e(VIEWMODELKEY, t.message)
            }

            override fun onResponse(
                call: Call<WeatherRequest?>,
                response: Response<WeatherRequest?>
            ) {
                if (response.isSuccessful) {
                    weather.postValue(response.body())
                } else {
                    Log.d(VIEWMODELKEY, "Code = " + response.code())
                    Log.d(VIEWMODELKEY, "message = " + response.message())
                }
            }

        })
    }

}