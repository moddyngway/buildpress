package com.example.adilproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.adilproject.fragment.news.NewsFragment
import com.example.adilproject.fragment.checks.CheckFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentPagerAdapter(this)
        main_view_pager.adapter = adapter

        val myNavTabs = arrayOf("Проекты", "Блог", "История покупок")

        TabLayoutMediator(tabLayoutViewPager, main_view_pager) { tab, position ->
            tab.text = myNavTabs[position]
        }.attach()
    }
}

class FragmentPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> com.example.adilproject.fragment.projects.ProjectFragment()
            1 -> NewsFragment()
            else -> CheckFragment()
        }
    }
}