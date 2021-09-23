package com.example.cobrtb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class AboutPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

class About(var hosts: String, var brand: String, var devs: String){

    var hostInfo: List<String> = mutableListOf("Lyba", "Selwa")

    fun displayHosts() {
        //display the hosts name and info
        //use xml to display pictures, etc
    }
}
