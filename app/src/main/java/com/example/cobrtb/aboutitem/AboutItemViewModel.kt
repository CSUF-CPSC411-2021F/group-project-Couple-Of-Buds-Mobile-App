package com.example.cobrtb.aboutitem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cobrtb.database.AboutDao

class AboutItemViewModel (
    val aboutId: Long,
    val database: AboutDao, // Data access object for the About entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped about object given its ID
    val about = database.get(aboutId)
}