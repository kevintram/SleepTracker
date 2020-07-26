package com.kiwicorp.sleeptracker.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiwicorp.sleeptracker.data.PickUp

@BindingAdapter("items")
fun RecyclerView.setItems(items: List<PickUp>?) {
    items?.let {
        (adapter as PickUpsListAdapter).submitList(items)
    }
}