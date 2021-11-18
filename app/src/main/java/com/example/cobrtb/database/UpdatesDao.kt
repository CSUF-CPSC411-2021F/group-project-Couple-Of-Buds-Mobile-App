package com.example.cobrtb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UpdatesDao {
    // Add an updates entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(updates: Updates)
    // fun insert(updates: Updates)

    // Update an updates entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(updates: Updates)

    // Custom query for retrieving a single Updates from a table in the database using
    // its updates id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from updates_table WHERE updatesId = :key")
    fun get(key: Long): LiveData<Updates>?

    // Custom query for retrieving all Update entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from updates_table ORDER BY updatesId DESC")
    fun getAllUpdates(): LiveData<List<Updates>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from updates_table")
    suspend fun clear()
    // fun clear()
}