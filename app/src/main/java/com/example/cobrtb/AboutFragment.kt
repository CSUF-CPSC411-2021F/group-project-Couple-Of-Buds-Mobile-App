package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cobrtb.databinding.FragmentAboutBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_about, container, false)

        val binding = FragmentAboutBinding.inflate(layoutInflater)

        binding.lybaButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_aboutFragment_to_hostLybaFragment)
        }

        binding.selwaButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_aboutFragment_to_hostSelwaFragment)
        }

        binding.textView10.text = "Join Lyba and Selwa as they navigate their experiences of being " +
                "Muslim American and children of immigrants. As a couple of buds constantly growing" +
                " and in bloom, Lyba and Selwa have deep and personal conversations about various " +
                "topics that they think are important to discuss!"


        return binding.root

    }


}