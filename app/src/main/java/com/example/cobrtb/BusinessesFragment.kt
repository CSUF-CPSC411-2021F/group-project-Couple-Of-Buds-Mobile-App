package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cobrtb.databinding.FragmentBusinessesBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BusinessesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBusinessesBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_businessesFragment_to_mahnjaanDecorates)
        }
        binding.button2.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_businessesFragment_to_forTheUmmah3)
        }


        return binding.root
    }
}