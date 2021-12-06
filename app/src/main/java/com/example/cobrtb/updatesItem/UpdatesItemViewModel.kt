package com.example.cobrtb.updatesItem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cobrtb.database.UpdatesDao

class UpdatesItemViewModel(
    val updatesId: Long,
    val database: UpdatesDao, // Data access object for the Updates entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped updates object given its ID
    val update = database.get(updatesId)
}