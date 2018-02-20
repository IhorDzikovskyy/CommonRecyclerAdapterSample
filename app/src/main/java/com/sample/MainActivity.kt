package com.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.sample.common.CommonRecyclerAdapter
import com.sample.viewholder.UserViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = CommonRecyclerAdapter({ UserViewHolder(it, { onImageClick() }) }, { onItemClick(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        loadData()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadData() {
        val users = ArrayList<User>()
        for (i in 0..99) users.add(User("User " + i, "Info"))
        adapter.items = users
    }

    private fun onItemClick(user: User?) {
        Log.d(this::class.java.simpleName, "Item Clicked:" + user?.name)
    }

    private fun onImageClick() {
        Log.d(this::class.java.simpleName, "Image Clicked")
    }
}
