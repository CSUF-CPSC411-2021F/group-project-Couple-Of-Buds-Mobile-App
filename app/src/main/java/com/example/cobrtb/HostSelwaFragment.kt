package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cobrtb.databinding.FragmentHostSelwaBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HostSelwaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HostSelwaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_host_selwa, container, false)

        val binding = FragmentHostSelwaBinding.inflate(layoutInflater)

        binding.textView7.text = "Hey y’all! I’m Selwa, co-host and 1/2 of COBRTB\n" +
                "-\n" +
                "I’m a third year Psychology and African American Studies student at Cal State Fullerton." +
                " Learning lessons from a variety of people and fostering deep connections are some of " +
                "the reasons I joined COBRTB. I looove reading and will pick up anything fantasy, action, " +
                "dystopian with a hint of ~romance~ (aka Shatter Me series ). Desserts and DC are the " +
                "keys to my heart and Marvel is great too, but DC is better.\n" +
                "\n" +
                "I’d say my biggest achievement is my inner growth, especially this past year. I feel " +
                "more emboldened and trusting of my own decisions. Still got a lot of work to do, but baby steps.\n" +
                "I feel most confident when I am surrounded by my inner circle. Also, when I know I’ve " +
                "put the work in, whether that is through my appearance or projects.\n" +
                "\n" +
                "Stay tuned for weekly episodes!"

        return binding.root


    }

}