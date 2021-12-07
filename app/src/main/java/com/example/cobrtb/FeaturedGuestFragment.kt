package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cobrtb.database.GuestDatabase
import com.example.cobrtb.databinding.FragmentFeaturedGuestBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FeaturedGuestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeaturedGuestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Create data binding
        val binding: FragmentFeaturedGuestBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_featured_guest, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Guest data access object.
        val dataSource = GuestDatabase.getInstance(application).guestDao

        // Create a factory that generates guestViewModels connected to the database.
        val viewModelFactory = GuestViewModelFactory(dataSource, application)

        // Generate an guestViewModel using the factory.
        val guestViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(GuestViewModel::class.java)

        guestViewModel.build()
        // Connect the guestViewModel with the variable in the layout
        binding.guestViewModel = guestViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        val name = guestViewModel.guestString

        binding.will.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_featuredGuestFragment_to_willFragment)

        }

        binding.immaGuess.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_featuredGuestFragment_to_immaGuessFragment)

        }

        return binding.root
    }

}