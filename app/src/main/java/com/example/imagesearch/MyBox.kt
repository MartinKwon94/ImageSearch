package com.example.imagesearch

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesearch.adapters.MyBoxAdapter
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.FragmentMyBoxBinding


class MyBox : Fragment() {

    private var _binding: FragmentMyBoxBinding? = null
    private lateinit var mContext: Context
    private lateinit var adapter: MyBoxAdapter
    private var heartItems: List<ItemSearch> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainActivity = activity as MainActivity
        heartItems = mainActivity.likedItems
        Log.d("liked", "${heartItems.size}")

        adapter = MyBoxAdapter(mContext).apply {
            mItems = heartItems.toMutableList()
        }
        _binding = FragmentMyBoxBinding.inflate(inflater, container, false).apply {
            recyclerView2.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerView2.adapter = adapter
        }
        return _binding?.root
    }
    fun selected(){
        if (::adapter.isInitialized){
        adapter.mItems = (activity as MainActivity).likedItems
        adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}