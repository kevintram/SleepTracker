package com.kiwicorp.sleeptracker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiwicorp.sleeptracker.data.PickUp
import com.kiwicorp.sleeptracker.databinding.ItemPickUpBinding

class PickUpsListAdapter (private val viewModel: MainActivityViewModel): ListAdapter<PickUp,PickUpViewHolder>(PickUpDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickUpViewHolder {
        return PickUpViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PickUpViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PickUpViewHolder private constructor(val binding: ItemPickUpBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(pickUp: PickUp) {
        binding.pickUp = pickUp
        binding.typeText.text = if (pickUp.isPickUp) "Pick Up" else "Put Down"
    }

    companion object {
        fun from(parent: ViewGroup): PickUpViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPickUpBinding.inflate(layoutInflater, parent, false)

            return PickUpViewHolder(binding)
        }
    }
}

class PickUpDiffCallBack: DiffUtil.ItemCallback<PickUp>() {
    override fun areContentsTheSame(oldItem: PickUp, newItem: PickUp): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: PickUp, newItem: PickUp): Boolean {
        return oldItem == newItem
    }
}