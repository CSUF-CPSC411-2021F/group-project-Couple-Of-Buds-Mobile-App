package com.example.cobrtb.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest_table")
data class Guest (

    // Defines the table's primary key. Primary keys are unique values that can be autogenerated.
    // They are used to differentiate one entity from another.
    @PrimaryKey(autoGenerate = true)
    var guestId: Long = 0L,

    // Non-rprimary key column. Data type is specified in the property.
    @ColumnInfo()
    var name: String = "",

    // Non-rprimary key column. Data type is specified in the property.
    @ColumnInfo()
    var contact: String = "",

    @ColumnInfo()
    var instagram: String = ""
)