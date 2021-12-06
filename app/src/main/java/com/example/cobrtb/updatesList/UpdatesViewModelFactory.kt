package com.example.cobrtb.updatesList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cobrtb.database.UpdatesDao

class UpdatesViewModelFactory(
    private val dataSource: UpdatesDao, // Data access object
    private val application: Application
) : ViewModelProvider.Factory {

    /**
     * Creates the UpdatesViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpdatesViewModel::class.java)) { // ViewModel class
            return UpdatesViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}