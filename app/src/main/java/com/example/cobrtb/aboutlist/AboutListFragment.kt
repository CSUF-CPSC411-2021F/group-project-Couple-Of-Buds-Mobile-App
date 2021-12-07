package com.example.cobrtb.aboutlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cobrtb.R
import com.example.cobrtb.database.AboutDatabase
import com.example.cobrtb.databinding.AboutListFragmentBinding

class AboutListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Create data binding
        val binding: AboutListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.about_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve About data access object.
        val dataSource = AboutDatabase.getInstance(application).aboutDao

        // Create a factory that generates AboutViewModels connected to the database.
        val viewModelFactory = AboutViewModelFactory(dataSource, application)

        // Generate an AboutViewModel using the factory.
        val aboutViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(AboutViewModel::class.java)

        // Connect the AboutViewModel with the variable in the layout
        binding.aboutViewModel = aboutViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        val aboutAdapter = AboutListAdapter(AboutListener {
               aboutId ->
            // Navigate to the about view and provide the id of the about referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
                AboutListFragmentDirections
                    .actionAboutListFragmentToAboutItemFragment(aboutId)
            )
        })
        // Attach about adapter.
        binding.aboutRecyclerview.adapter = aboutAdapter

        // Submit an updated list to the about listAdapter whenever it changes. Take note
        // aboutList is a LiveData object.
        aboutViewModel.aboutList.observe(viewLifecycleOwner, Observer {
            it?.let {
                aboutAdapter.submitList(it)
            }
        })
        return binding.root
    }

}