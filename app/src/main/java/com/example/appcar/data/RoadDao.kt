package com.example.appcar.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appcar.data.model.Road

@Dao
interface RoadDao {
    @Query("SELECT * FROM road")
    suspend fun getAll(): List<Road>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>


    @Query("SELECT * FROM road WHERE id IN (:roadList) ")
    suspend fun findCar(roadList: List<Int>): List<Road>

    @Insert
    suspend fun insertAll(roadList: List<Road>)

    @Delete
    suspend fun delete(road: Road)

    @Update
    suspend fun updateRoad(road: Road)
}