package com.jscode.bipolarfactorydemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jscode.bipolarfactorydemo.databinding.ActivityMainBinding
import com.jscode.bipolarfactorydemo.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val sectionsPagerAdapter = ViewPagerAdapter(this)
        val viewPager:ViewPager2=binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Items"
                1 -> tab.text = "Cats"
            }
        }.attach()
    }
}