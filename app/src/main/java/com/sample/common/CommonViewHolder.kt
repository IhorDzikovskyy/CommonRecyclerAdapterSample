package com.sample.common

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.sample.inflate

abstract class CommonViewHolder<in T>(parent: ViewGroup, layoutRes: Int,
                                      val rootView: View = parent.inflate(layoutRes))
    : RecyclerView.ViewHolder(rootView) {

    abstract fun bindItem(item: T?)
}