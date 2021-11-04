package com.example.cobrtb

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_about, container, false)

        //val binding = FragmentAboutBinding.inflate(layoutInflater)

        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater, R.layout.fragment_about,
            container, false)


        binding.lybaButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_aboutFragment_to_hostLybaFragment)
        }

        binding.selwaButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_aboutFragment_to_hostSelwaFragment)
        }



        return binding.root

    }




}