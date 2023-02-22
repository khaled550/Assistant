package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.Trip

@androidx.room.Dao
interface Dao {

    @Insert
    fun insert(trip: Trip)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

    @Query("delete from trip")
    fun deleteAllTrips()

    @Query("select * from trip order by date desc")
    fun getAllTrips(): LiveData<List<Trip>>
}