package com.example.firstapp.stdio.weatherapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.firstapp.stdio.weatherapp.R
import com.example.firstapp.stdio.weatherapp.model.WeatherModel
import com.example.firstapp.stdio.weatherapp.model.WeatherRequest
import com.example.firstapp.stdio.weatherapp.utils.WeatherUtils
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.android.synthetic.main.fragment_week.*
import java.lang.String

/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment() {

    private lateinit var forecast: TextView
    private lateinit var windSpeed: TextView
    private lateinit var viewHumitidy: TextView
    private lateinit var viewPrecipitation: TextView
    private lateinit var viewTemp: TextView
    private lateinit var viewMaxTemp: TextView
    private lateinit var viewMinTemp: TextView
    private lateinit var imageTemp: ImageView
    private lateinit var swiper: SwipeRefreshLayout
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecast = view.findViewById(R.id.textViewForecast)
        windSpeed = view.findViewById(R.id.textViewWindSpeed)
        viewHumitidy = view.findViewById(R.id.textViewHumidity)
        viewPrecipitation = view.findViewById(R.id.textViewPrecipitation)
        viewTemp = view.findViewById(R.id.textViewTemp)
        viewMaxTemp = view.findViewById(R.id.textViewMaxTemp)
        viewMinTemp = view.findViewById(R.id.textViewMinTemp)
        swiper = view.findViewById(R.id.swipeRefresh)
        imageTemp = view.findViewById(R.id.imageView)
        swiper.setOnRefreshListener (  weatherViewModel::loadWeather )
        weatherViewModel.weather.observe(this, Observer { weatherRequest ->
            swiper.isRefreshing = false
            updateUI(weatherRequest.today)
        })
    }

    fun updateUI(weather: WeatherModel){
        forecast.setText(weather.forecast)
        windSpeed.setText(String.valueOf(weather.wind_speed))
        viewHumitidy.setText(String.valueOf(weather.humidity))
        viewPrecipitation.setText(String.valueOf(weather.precipitation))
        viewTemp.setText(String.valueOf(weather.temp))
        viewMaxTemp.setText(String.valueOf(weather.max_temp))
        viewMinTemp.setText(String.valueOf(weather.min_temp))
        imageView.setImageResource(WeatherUtils.loadWeatherIconToday(weather.forecast))

    }


    override fun onStart() {
        super.onStart()
        swiper.isRefreshing = true
        weatherViewModel.loadWeather()
    }

}
