package com.example.cobrtb.updatesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cobrtb.database.DataGenerator
import com.example.cobrtb.database.UpdatesDao
import kotlinx.coroutines.launch

class UpdatesViewModel (
    val database: UpdatesDao, // Data access object for the Updates entity
    application: Application
) : AndroidViewModel(application) {

    val updatesList = database.getAllUpdates()

    /**
     * Pre-populate the database
     */
    fun build() {
        viewModelScope.launch {
            database.clear()
            for (item in DataGenerator.announcements) {
                database.insert(item)
            }
        }
    }

}