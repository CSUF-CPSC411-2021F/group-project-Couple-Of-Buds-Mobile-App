package com.example.cobrtb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class Promo_Page: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

class Promo_Page(var hosts: String, var brand: String, var devs: String){

    var business: List<String> = mutableListOf("Mahnjaan Decorates", "For The Ummah")

    fun displayFirstBusiness() {
        //display the information regarding the first Business Promo
        //use xml to display pictures, and intro videos, etc.
    }
}