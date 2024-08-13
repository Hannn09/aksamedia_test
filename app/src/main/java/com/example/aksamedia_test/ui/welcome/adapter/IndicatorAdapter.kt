package com.example.aksamedia_test.ui.welcome.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aksamedia_test.ui.welcome.first.FirstWelcomeFragment
import com.example.aksamedia_test.ui.welcome.second.SecondWelcomeFragment
import com.example.aksamedia_test.ui.welcome.third.ThirdWelcomeFragment

class IndicatorAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FirstWelcomeFragment()
            1 -> fragment = SecondWelcomeFragment()
            2 -> fragment = ThirdWelcomeFragment()
        }

        return fragment as Fragment
    }
}