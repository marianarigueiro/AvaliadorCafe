package com.example.avaliadorcafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.avaliadorcafe.model.Cafe

@Database(entities = [Cafe::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cafeDao(): CafeDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cafes_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }
}