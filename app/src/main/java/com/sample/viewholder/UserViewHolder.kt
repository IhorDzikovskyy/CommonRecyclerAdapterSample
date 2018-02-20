package com.sample.viewholder

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sample.R
import com.sample.User
import com.sample.common.CommonViewHolder
import com.sample.onClick
import org.jetbrains.anko.find

class UserViewHolder(parent: ViewGroup, private val onImageClick: (() -> Unit)? = null)
    : CommonViewHolder<User>(parent, R.layout.item_user) {

    private val userImage: ImageView = rootView.find(R.id.userImage)
    private val userName: TextView = rootView.find(R.id.userName)
    private val userInfo: TextView = rootView.find(R.id.userInfo)

    override fun bindItem(item: User?) {
        userName.text = item?.name
        userInfo.text = item?.info
        onImageClick?.let { userImage.onClick { it() } }
    }
}