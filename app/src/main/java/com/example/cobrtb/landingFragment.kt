package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cobrtb.databinding.FragmentAboutBinding
import com.example.cobrtb.databinding.FragmentLandingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [landingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class landingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLandingBinding.inflate(layoutInflater)

        binding.toAbout.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_landingFragment_to_aboutFragment)
        }
        binding.toUpdates.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_landingFragment_to_updatesListFragment)
        }
        binding.toGuests.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_landingFragment_to_featuredGuestFragment)
        }
        binding.toBusinesses.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_landingFragment_to_businessesFragment)
        }


        return binding.root

    }
}