package com.example.cobrtb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cobrtb.databinding.ActivityFeaturedGuestPageBinding


/**
 * Main interface of the application
 */
class FeaturedGuestPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creat data binding and assign layout for the activity.
        val binding: ActivityFeaturedGuestPageBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_featured_guest_page)

        // Setup navigation controller and action bar.
        val navController = this.findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * Override the default implementation of the Up button so that it uses our
     * navController.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}