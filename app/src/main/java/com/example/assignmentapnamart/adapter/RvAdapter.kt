package com.example.assignmentapnamart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentapnamart.R
import com.example.assignmentapnamart.models.ResponseDataItem

class RvAdapter(): PagingDataAdapter<ResponseDataItem, RvAdapter.RvViewHolder>(DataDifferntiator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_layout, parent, false)
        return RvViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val item = getItem(position)
        holder.authName.text = item?.author
        Glide.with(holder.itemView.context).load(item?.download_url).into(holder.authImg)
    }

    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authName: TextView = itemView.findViewById(R.id.nameTxt)
        val authImg: ImageView = itemView.findViewById(R.id.imageView)
    }

    object DataDifferntiator : DiffUtil.ItemCallback<ResponseDataItem>() {

        override fun areItemsTheSame(oldItem: ResponseDataItem, newItem: ResponseDataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResponseDataItem, newItem: ResponseDataItem): Boolean {
            return oldItem == newItem
        }
    }
}