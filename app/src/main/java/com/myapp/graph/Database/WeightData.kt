package com.myapp.graph.Database



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weights")
data class WeightData(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "weightNumber") val weightNumber: Float,

    )