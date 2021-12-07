package com.example.cobrtb.aboutitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cobrtb.R
import com.example.cobrtb.database.AboutDatabase
import com.example.cobrtb.databinding.AboutItemFragmentBinding

class AboutItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Retrieve arguments passed from the RecyclerView
        val args = AboutItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: AboutItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.about_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve About data access object.
        val dataSource = AboutDatabase.getInstance(application).aboutDao

        // Create a factory that generates an AboutViewModel connected to the database. The
        // aboutId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            AboutItemViewModelFactory(args.aboutId, dataSource, application)

        // Generate an AboutViewModel using the factory.
        val aboutItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(AboutItemViewModel::class.java)

        // Connect the AboutViewModel with the variable in the layout
        binding.aboutItemViewModel = aboutItemViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }

}