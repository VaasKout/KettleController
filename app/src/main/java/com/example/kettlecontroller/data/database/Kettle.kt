package com.example.kettlecontroller.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kettle_table")
data class Kettle(
    @PrimaryKey
    @ColumnInfo(name = "macAddress") val mac: String,
    @ColumnInfo(name = "name") val name: String,
)