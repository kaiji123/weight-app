package com.myapp.graph.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myapp.graph.GraphFragment


@Database(entities = arrayOf(WeightData::class), version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weightDao(): WeightDao
    companion object {
        private var INSTANCE: AppDatabase? = null


        //you can have two instances... one for graph fragment and second one is for the activity
        fun getInstance(context: GraphFragment): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = context.context?.let {
                        Room.databaseBuilder(
                            it,
                            AppDatabase::class.java, "weightDatabase" // Database Name
                        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "weightDatabase" // Database Name
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}