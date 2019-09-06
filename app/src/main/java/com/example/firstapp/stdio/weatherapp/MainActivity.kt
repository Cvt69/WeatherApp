package com.example.firstapp.stdio.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.firstapp.stdio.weatherapp.fragments.FragmentPageAdapter
import com.example.firstapp.stdio.weatherapp.fragments.TodayFragment
import com.example.firstapp.stdio.weatherapp.fragments.WeekFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FragmentPageAdapter
    private lateinit var tab_layout: TableLayout
    private lateinit var viewpager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.viewpager = findViewById(R.id.viewpager)
        //this.tab_layout = findViewById(R.id.tab_layout)
        val fragments = Arrays.asList(TodayFragment(), WeekFragment())
        adapter = FragmentPageAdapter(supportFragmentManager, ArrayList(fragments))
        this.viewpager.adapter = adapter

    }
}
