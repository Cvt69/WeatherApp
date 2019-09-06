package com.example.firstapp.stdio.weatherapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.firstapp.stdio.weatherapp.R
import com.example.firstapp.stdio.weatherapp.model.WeatherRequest

/**
 * A simple [Fragment] subclass.
 */
class WeekFragment : Fragment() {

    private lateinit var list: RecyclerView
    private lateinit var swiper: SwipeRefreshLayout
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list = view.findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(context)
        weatherViewModel.weather.observe(this, Observer { weatherRequest ->
            swiper.isRefreshing = false
            list.adapter = WeekWeatherAdapter(weatherRequest.weekForecast)
        })
        swiper = view.findViewById(R.id.swipeRefresh)
        swiper.setOnRefreshListener ( weatherViewModel::loadWeather )
        super.onViewCreated(view, savedInstanceState)
    }

    fun updateUI(weather: WeatherRequest){}

    override fun onStart() {
        super.onStart()
        swiper.isRefreshing = true
        weatherViewModel.loadWeather()
    }

}
