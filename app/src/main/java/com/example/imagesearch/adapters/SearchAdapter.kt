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
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.imagesearch.MainActivity
import com.example.imagesearch.data.ItemSearch
import com.example.imagesearch.databinding.ItemImageBinding

class SearchAdapter(private val mContext: Context) :
    RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {

    var mItems = ArrayList<ItemSearch>()
    fun clearItem() {
        mItems.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount() = mItems.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = mItems[position]
        Glide.with(mContext).load(currentItem.url).transform(MultiTransformation(FitCenter(),RoundedCorners(8))).into(holder.iv_profile)

        holder.iv_like.visibility = if (currentItem.isLike) View.VISIBLE else View.INVISIBLE
        holder.tv_text.text = mItems[position].title
        holder.tv_date.text = mItems[position].dateTime

    }

    inner class ItemViewHolder(binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        var iv_profile: ImageView = binding.ivProfile
        var iv_like: ImageView = binding.ivLike
        var tv_text: TextView = binding.tvTitle
        var tv_date: TextView = binding.tvDate
        var cl_item: ConstraintLayout = binding.clItem

        init {
            iv_like.visibility = View.GONE
            iv_profile.setOnClickListener(this)
            cl_item.setOnClickListener(this)
        }


        override fun onClick(view: View) {
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val item = mItems[position]
            item.isLike = !item.isLike
            if (item.isLike) {
                (mContext as MainActivity).addLikedItem(item)
            } else {
                (mContext as MainActivity).removeLikedItem(item)
            }
            notifyItemChanged(position)
        }


    }

}