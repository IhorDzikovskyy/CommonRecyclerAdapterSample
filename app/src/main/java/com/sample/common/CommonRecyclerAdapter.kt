package com.sample.common

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.sample.onClick

class CommonRecyclerAdapter<T>(private val viewHolderFactory: ((parent: ViewGroup) -> CommonViewHolder<T>),
                               private var onItemClick: ((T?) -> Unit)? = null)
    : RecyclerView.Adapter<CommonViewHolder<T>>() {

    var items: List<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T> {
        return viewHolderFactory(parent)
    }

    override fun onBindViewHolder(holder: CommonViewHolder<T>, position: Int) {
        val item = items?.get(position)
        holder.bindItem(item)
        onItemClick?.let { holder.rootView.onClick { it.invoke(item) } }
    }

    override fun getItemCount(): Int = items?.size ?: 0

}