package com.example.imagesearch

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesearch.adapters.MyBoxAdapter
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.FragmentMyBoxBinding


class MyBox : Fragment() {

    lateinit var binding: FragmentMyBoxBinding
    private var _binding: FragmentMyBoxBinding? = null
    private lateinit var mContext: Context
    private lateinit var adapter: MyBoxAdapter
    private var likedItems: List<ItemSearch> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = MyBoxAdapter(mContext).apply {
            mItems = likedItems.toMutableList()
        }
        binding = FragmentMyBoxBinding.inflate(inflater, container, false).apply {
            recyclerView2.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerView2.adapter = adapter
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}