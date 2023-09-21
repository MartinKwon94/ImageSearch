package com.example.imagesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.imagesearch.MainViewPagerAdapter
import com.example.imagesearch.R
import com.example.imagesearch.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

//    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this@MainActivity) }

    private val tabTextList = listOf("Search", "MyBox")
    private val tabIconList = listOf(R.drawable.ic_search, R.drawable.ic_box)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewPager.adapter = MainViewPagerAdapter(this)

        TabLayoutMediator(binding.tapLayout, binding.viewPager){tab,pos ->
            tab.text=tabTextList[pos]
            tab.setIcon(tabIconList[pos])
        }.attach()

    }

//    private fun viewPagerChanged() = with(binding) {
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                val nFragment = mainViewPagerAdapter.getFragmentByIndex(position)
//            }
//
//        })
//    }
}