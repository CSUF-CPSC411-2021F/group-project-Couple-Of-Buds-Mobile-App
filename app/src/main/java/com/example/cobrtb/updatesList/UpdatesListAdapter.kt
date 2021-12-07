package com.example.cobrtb.updatesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cobrtb.database.Updates
import com.example.cobrtb.databinding.UpdatesItemBinding

class UpdatesListAdapter(val clickListener: UpdatesListener) : ListAdapter<Updates,
        UpdatesListAdapter.ItemViewHolder>(UpdatesDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: UpdatesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign an updates object and clickListener to the ItemViewHolder
         */
        fun bind(item: Updates, clickListener: UpdatesListener) {
            binding.updates = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (UpdateListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UpdatesItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to the ItemViewHolder and its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Assign the corresponding element from the data and the click listener. Take note getItem
        // is a function provided by ListAdapter.
        holder.bind(getItem(position), clickListener)
    }
}

/**
 * Manages a RecyclerView list using the Eugene W. Myers's difference algorithm to reduce processing.
 */
class UpdatesDiffCallback : DiffUtil.ItemCallback<Updates>() {
    /**
     * We use updateId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: Updates, newItem: Updates): Boolean {
        return oldItem.updatesId == newItem.updatesId
    }

    /**
     * We check all properties to check equality between Update objects.
     */
    override fun areContentsTheSame(oldItem: Updates, newItem: Updates): Boolean {
        return oldItem.name == newItem.name && oldItem.description == newItem.description
    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class UpdatesListener(val clickListener: (updatesId: Long) -> Unit) {
    fun onClick(updates: Updates) = clickListener(updates.updatesId)
}