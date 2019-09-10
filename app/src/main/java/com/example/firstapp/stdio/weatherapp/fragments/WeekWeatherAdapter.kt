package com.example.firstapp.stdio.weatherapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.stdio.weatherapp.R
import com.example.firstapp.stdio.weatherapp.model.WeatherModel
import java.lang.String
import java.util.List

class WeekWeatherAdapter(private var weatherList: List<WeatherModel>) :
    RecyclerView.Adapter<WeekWeatherAdapter.WeatherHolder>() {
    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(weatherList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_weather, parent, false)
        return WeatherHolder(
            view,
            view.findViewById(R.id.textViewTitle),
            view.findViewById(R.id.imageViewForecastWeek),
            view.findViewById(R.id.textViewForecastWeek),
            view.findViewById(R.id.textViewMaxTempWeek),
            view.findViewById(R.id.textViewMinTempWeek)
        )
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }


    class WeatherHolder(
        var itemView: View,
        private var textViewTitle: TextView,
        var imageViewForecastWeek: ImageView,
        var textViewForecastWeek: TextView,
        var textViewMaxTempWeek: TextView,
        var textViewMinTempWeek: TextView
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: WeatherModel) {
            textViewTitle.setText(model.title)
            textViewForecastWeek.setText(model.forecast)
            textViewMaxTempWeek.setText(String.valueOf(model.max_temp))
            textViewMinTempWeek.setText(String.valueOf(model.min_temp))
        }
    }

}
