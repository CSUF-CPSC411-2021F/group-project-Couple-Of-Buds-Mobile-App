package com.example.cobrtb

import android.app.Application
import androidx.lifecycle.*
import com.example.cobrtb.database.Guest
import com.example.cobrtb.database.GuestDAO
import com.example.cobrtb.database.GuestGenerator
import kotlinx.coroutines.launch

/**
 * GuestViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class GuestViewModel(
    val database: GuestDAO, // Data access object for the Guest entity
    application: Application) : AndroidViewModel(application) {


    // Represented as a LiveData<List<Guest>>
    fun build() {
        viewModelScope.launch {
            database.clear()
            for (item in GuestGenerator.guests) {
                database.insert(item)
            }
        }
    }

    val guestList = database.getAllGuests()

    var guestString = Transformations.map(guestList) {
            guests -> // guests refer to the underlying data List<Intersection>
        var result = ""
        // Retrieve each Intersection object from the list
        for (guest in guests) {
            // Create a string using the Intersection name and location.
            // The guest string is appended to a longer string with all guests.
            result += "Name: ${guest.name}\nContact: ${guest.contact}\n ${guest.instagram}"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }


}