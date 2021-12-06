package com.example.cobrtb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AboutDao {
    // Add an about entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(about: About)

    // Update an about entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(about: About)

    // Custom query for retrieving a single About from a table in the database using
    // its about id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from about_table WHERE aboutId = :key")
    fun get(key: Long): LiveData<About>?

    // Custom query for retrieving all About entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from about_table ORDER BY aboutId DESC")
    fun getAllAbout(): LiveData<List<About>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from about_table")
    suspend fun clear()
}