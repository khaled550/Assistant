package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip")
data class Trip(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val date: String,
    val vehicle_type: String,
    val pl: String,
    val vendor: String,
    val from: String,
    val to: String,
    val cost: String,
    val requester: String,
    val remarks: String,
)
