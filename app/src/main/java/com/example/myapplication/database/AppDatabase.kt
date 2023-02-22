package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.model.Trip

@Database(entities = [Trip::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun tripDao(): Dao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: AppDatabase) {
            db.tripDao().insert(
                Trip(null,
                    "2-2-2023",
                    "DC",
                    "WCT",
                    "Tariq",
                    "ADM",
                    "WTTC",
                    "75",
                    "Kevin",
                    ""
                ))
        }
    }




}