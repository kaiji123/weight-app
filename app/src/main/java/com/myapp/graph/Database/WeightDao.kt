package com.myapp.graph.Database



import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

import kotlinx.coroutines.flow.Flow

@Dao
interface WeightDao {
    @Query("SELECT * FROM weights")
    fun getAll(): List<WeightData>


/*
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): AnkiData
    */


    @Insert(onConflict = REPLACE)
    fun insertWeight(weight: WeightData)

    @Delete
    fun delete(weight:WeightData)

    @Query("DELETE FROM weights")
    fun deleteAll()
}