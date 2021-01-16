package com.peopleinteractive.task.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peopleinteractive.task.feature.home.HomeListAdapter

@BindingAdapter("adapter")
fun setHomeListAdapter(recyclerView: RecyclerView, homeAdapter: HomeListAdapter) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        adapter = homeAdapter
    }
}
