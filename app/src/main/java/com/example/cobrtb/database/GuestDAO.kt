package com.example.cobrtb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the Guest entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface GuestDAO {
    // Add an guest entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(guest: Guest)

    // Update an guest entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(guest: Guest)

    // Custom query for retrieving a single Guest from a table in the database using
    // its guest id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from guest_table WHERE guestId = :key")
    fun get(key: Long): LiveData<Guest>?

    // Custom query for retrieving all Guest entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from guest_table ORDER BY guestId DESC")
    fun getAllGuests(): LiveData<List<Guest>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from guest_table")
    suspend fun clear()
}