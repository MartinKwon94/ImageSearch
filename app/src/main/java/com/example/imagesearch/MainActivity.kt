package com.example.imagesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.imagesearch.adapters.MainViewPagerAdapter
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabTextList = listOf("Search", "MyBox")
    private val tabIconList = listOf(R.drawable.ic_search, R.drawable.ic_box)
    private val adapter = MainViewPagerAdapter(this)
    var likedItems: ArrayList<ItemSearch> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tapLayout, binding.viewPager) { tab, pos ->
            tab.text = tabTextList[pos]
            tab.setIcon(tabIconList[pos])
        }.attach()
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapter.getMyBoxFragment().selected()
//                adapter.getSearchFragment().selected()

            }
        })
    }

    fun addLikedItem(item: ItemSearch) {
        if (!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    fun removeLikedItem(item: ItemSearch) {
        likedItems.remove(item)
    }
}