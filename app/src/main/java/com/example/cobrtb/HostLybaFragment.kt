package com.example.cobrtb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cobrtb.databinding.FragmentHostLybaBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HostLybaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HostLybaFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_host_lyba, container, false)

        val binding = FragmentHostLybaBinding.inflate(layoutInflater)

        binding.textView6.text = "Hello Everyone! My name is Lyba, co-host and the other 1/2 of COBRTB\n" +
                "-\n" +
                "I am a third year Computer Science Student at Cal State Fullerton. Having insightful" +
                " and deep conversations with Selwa and others around me was the main inspiration for starting up this podcast. " +
                "Selwa and I share the love for dystopian novels which allows us to bond over different book plots! " +
                "I also love to play the piano in my free time and have recently picked up crocheting as a way to relieve stress." +
                " I also love love loveee sunsets!! Often times after classes I'll go outside to breath some fresh air and enjoy the sunset.\n" +
                "\n" +
                "I believe that my biggest personal achievement is my attitude towards life and making " +
                "sure to be kind and always have a smile on my face for others. Life is too short and" +
                " not promised to hold grudges, and I think it's always best to forgive others.\n" +
                "I feel most confident when I am on stage and presenting in some kind of form. The" +
                " nervousness before and the adrenaline and bubbly feeling after giving a presentation " +
                "can't be compared to any other feeling.\n" +
                "\n" +
                "Make sure to leave any questions for us in the question boxes in our stories, and " +
                "we will answer them in our podcast episodes!"

        return binding.root
    }



}