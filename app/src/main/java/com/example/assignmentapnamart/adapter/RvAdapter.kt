package com.example.assignmentapnamart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
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
    }

    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authName: TextView = itemView.findViewById(R.id.nameTxt)
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