package com.example.imagesearch.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imagesearch.MyBox
import com.example.imagesearch.Search

class MainViewPagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {
    private val search = Search()
    private val myBox = MyBox()
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> search
            else -> myBox
        }
    }
    fun getSearchFragment() = search
    fun getMyBoxFragment() = myBox
}