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



}