package com.example.imagesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagesearch.adapters.MainViewPagerAdapter
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabTextList = listOf("Search", "MyBox")
    private val tabIconList = listOf(R.drawable.ic_search, R.drawable.ic_box)

    var likedItems: ArrayList<ItemSearch> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = MainViewPagerAdapter(this)

        TabLayoutMediator(binding.tapLayout, binding.viewPager){tab,pos ->
            tab.text=tabTextList[pos]
            tab.setIcon(tabIconList[pos])
        }.attach()
    }

    fun addLikedItem(item: ItemSearch){
        if (!likedItems.contains(item)){
            likedItems.add(item)
        }
    }




}