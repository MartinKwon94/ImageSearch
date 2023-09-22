package com.example.imagesearch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.ItemImageBinding

class MyBoxAdapter(var mContext: Context) :
    RecyclerView.Adapter<MyBoxAdapter.ItemViewHolder>() {

    var mItems = mutableListOf<ItemSearch>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Glide.with(mContext).load(mItems[position].url).into(holder.iv_profile)
        holder.tv_text.text = mItems[position].title
        holder.iv_like.visibility = View.GONE
        holder.tv_date.text = mItems[position].dateTime

    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class ItemViewHolder(binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        var iv_profile: ImageView = binding.ivProfile
        var tv_text: TextView = binding.tvTitle
        var iv_like: ImageView = binding.ivLike
        var tv_date: TextView = binding.tvDate
        var cl_item: ConstraintLayout = binding.clItem

        init {
            iv_like.visibility = View.GONE
            cl_item.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mItems.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }
}