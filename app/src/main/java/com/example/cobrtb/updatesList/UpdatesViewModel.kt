package com.example.cobrtb.updatesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import com.example.cobrtb.database.Updates
import com.example.cobrtb.database.UpdatesDao
import kotlinx.coroutines.launch

class UpdatesViewModel (
    val database: UpdatesDao, // Data access object for the Updates entity
    application: Application
) : AndroidViewModel(application) {

    // Used to assign and retrieve name and description values from the interface.
    var name = MutableLiveData("")
    var description = MutableLiveData("")

    // Retrieves all Updates objects from the database
    // Represented as a LiveData<List<Updates>>
    val updatesList = database.getAllUpdates()

    /**
     * Inserts the Update object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Updates object using data stored in the EditText views
            var updates = Updates()
            updates.name = name.value.toString()
            updates.description = description.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(updates)
        }
    }

    /**
     * Deletes all Updates entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}