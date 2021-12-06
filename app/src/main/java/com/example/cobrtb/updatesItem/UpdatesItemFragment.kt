package com.example.cobrtb.updatesItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cobrtb.R
import com.example.cobrtb.database.UpdatesDatabase
import com.example.cobrtb.databinding.UpdatesItemFragmentBinding

class UpdatesItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve arguments passed from the RecyclerView
        val args = UpdatesItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: UpdatesItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.updates_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve Update data access object.
        val dataSource = UpdatesDatabase.getInstance(application).updatesDao

        // Create a factory that generates an UpdateViewModel connected to the database. The
        // updateId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            UpdatesItemViewModelFactory(args.updatesId, dataSource, application)

        // Generate an UpdateViewModel using the factory.
        val updatesItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(UpdatesItemViewModel::class.java)

        // Connect the UpdateViewModel with the variable in the layout
        binding.updatesItemViewModel = updatesItemViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }
}