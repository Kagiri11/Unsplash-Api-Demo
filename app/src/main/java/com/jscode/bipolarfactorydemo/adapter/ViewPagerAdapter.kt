package com.jscode.bipolarfactorydemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jscode.bipolarfactorydemo.ui.CatsFragment
import com.jscode.bipolarfactorydemo.ui.ItemsFragment
import java.lang.Exception

class ViewPagerAdapter(frag:FragmentActivity) : FragmentStateAdapter(frag) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ItemsFragment.newInstance()
            1 -> CatsFragment.newInstance()
            else -> throw Exception("Invalid tab position")
        }
    }
}