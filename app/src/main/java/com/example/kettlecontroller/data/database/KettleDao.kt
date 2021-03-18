package com.example.kettlecontroller.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface KettleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKettle(kettle: Kettle)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKettleList(kettleList: List<Kettle>)

    @Update
    suspend fun updateKettle(kettle: Kettle)

    @Delete
    suspend fun deleteKettle(kettle: Kettle)

    @Query("SELECT * FROM kettle_table")
    fun getAllKettles(): Flow<List<Kettle>>

    @Query("DELETE FROM kettle_table")
    suspend fun clearDatabase()
}