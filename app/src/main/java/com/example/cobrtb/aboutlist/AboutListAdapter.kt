package com.example.cobrtb.aboutlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cobrtb.database.About
import com.example.cobrtb.databinding.AboutItemBinding


/**
 * A RecyclerView adapter that uses the DiffCallback for better performance and a listener to handle
 * clicks/taps on each item.
 */
class AboutListAdapter(val clickListener: AboutListener) : ListAdapter<About,
        AboutListAdapter.ItemViewHolder>(AboutDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: AboutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign an about object and clickListener to the ItemViewHolder
         */
        fun bind(item: About, clickListener: AboutListener) {
            binding.about = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (AboutListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AboutItemBinding.inflate(layoutInflater, parent, false)
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
class AboutDiffCallback : DiffUtil.ItemCallback<About>() {
    /**
     * We use aboutId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: About, newItem: About): Boolean {
        return oldItem.aboutId == newItem.aboutId
    }

    /**
     * We check all properties to check equality between About objects.
     */
    override fun areContentsTheSame(oldItem: About, newItem: About): Boolean {
        return oldItem.name == newItem.name && oldItem.location == newItem.location
    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class AboutListener(val clickListener: (aboutId: Long) -> Unit) {
    fun onClick(about: About) = clickListener(about.aboutId)
}