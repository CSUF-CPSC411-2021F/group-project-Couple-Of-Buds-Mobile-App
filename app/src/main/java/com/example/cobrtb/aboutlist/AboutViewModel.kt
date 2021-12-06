package com.example.cobrtb.aboutlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cobrtb.database.About
import com.example.cobrtb.database.AboutDao
import kotlinx.coroutines.launch

class AboutViewModel (

    val database: AboutDao, // Data access object for the About entity
    application: Application
) : AndroidViewModel(application) {

    // Used to assign and retrieve name and location values from the interface.
    var name = MutableLiveData("")
    var location = MutableLiveData("")

    // Retrieves all About objects from the database
    // Represented as a LiveData<List<About>>
    val aboutList = database.getAllAbout()

    /**
     * Inserts the About object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create About object using data stored in the EditText views
            var about = About()
            about.name = name.value.toString()
            about.location = location.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(about)
        }
    }

    /**
     * Deletes all About entities in the database.
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