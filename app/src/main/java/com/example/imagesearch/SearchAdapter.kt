package com.example.imagesearch

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearch.data.ItemSearch
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder

class SearchAdapter(private val mContext: Context) :
    RecyclerView.Adapter<SearchAdapter.Holder>() {

    var items = ArrayList<ItemSearch>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = ClipData.Items[position]
        holder.itemImageView.setImageResource(mContext[position].Image)
    }

}