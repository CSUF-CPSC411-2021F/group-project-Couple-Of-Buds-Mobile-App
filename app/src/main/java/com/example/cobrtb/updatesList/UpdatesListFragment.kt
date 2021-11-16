package com.example.cobrtb.updatesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cobrtb.R
import com.example.cobrtb.database.UpdatesDatabase
import com.example.cobrtb.databinding.UpdatesListFragmentBinding

class UpdatesListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create data binding
        val binding: UpdatesListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.updates_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Updates data access object.
        val dataSource = UpdatesDatabase.getInstance(application).updatesDao

        // Create a factory that generates UpdatesViewModels connected to the database.
        val viewModelFactory = UpdatesViewModelFactory(dataSource, application)

        // Generate an UpdatesViewModel using the factory.
        val updatesViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(UpdatesViewModel::class.java)

        // Connect the UpdatesViewModel with the variable in the layout
        binding.updatesViewModel = updatesViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var updatesAdapter = UpdatesListAdapter(UpdatesListener {
                updatesId ->
            // Navigate to the updates view and provide the id of the updates referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
                UpdatesListFragmentDirections
                    .actionUpdatesListFragmentToUpdatesItemFragment(updatesId)
            )
        })
        // Attach updates adapter.
        binding.updatesRecyclerview.adapter = updatesAdapter

        // Submit an updated list to the updates listAdapter whenever it changes. Take note
        // updatesList is a LiveData object.
        updatesViewModel.updatesList.observe(viewLifecycleOwner, Observer {
            it?.let {
                updatesAdapter.submitList(it)
            }
        })
        return binding.root
    }
}