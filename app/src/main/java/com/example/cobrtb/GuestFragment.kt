package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cobrtb.databinding.FragmentGuestBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GuestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GuestFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGuestBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return binding.root
    }

}