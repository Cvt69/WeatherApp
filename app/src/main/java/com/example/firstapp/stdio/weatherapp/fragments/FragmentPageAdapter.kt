package com.example.firstapp.stdio.weatherapp.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class FragmentPageAdapter(fm: FragmentManager?, var fragment: ArrayList<Fragment>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragment.get(position)
    }

    override fun getCount(): Int {
        return fragment.size
    }
}