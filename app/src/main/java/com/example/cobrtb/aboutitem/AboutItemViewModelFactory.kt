package com.example.cobrtb.aboutitem

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobrtb.database.AboutDao

class AboutItemViewModelFactory (
    private val aboutId: Long,
    private val dataSource: AboutDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the AboutViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutItemViewModel::class.java)) { // ViewModel class
            return AboutItemViewModel(aboutId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}