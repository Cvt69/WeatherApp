package com.example.firstapp.stdio.weatherapp.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.List

class FragmentPageAdapter(fm: FragmentManager?, var fragment: List<Fragment>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragment.get(position)
    }

    override fun getCount(): Int {
        return fragment.size
    }
}