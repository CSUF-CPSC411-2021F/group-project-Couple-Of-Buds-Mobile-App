package com.example.cobrtb

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobrtb.database.GuestDAO

/**
 * Generates an GuestViewModel tied to the database.
 */
class GuestViewModelFactory(
    private val dataSource: GuestDAO, // Data access object
    private val application: Application): ViewModelProvider.Factory {

    /**
     * Creates the GuestViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GuestViewModel::class.java)) { // ViewModel class
            return GuestViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}