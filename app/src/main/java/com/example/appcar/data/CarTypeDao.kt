package com.example.appcar.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.appcar.data.model.CarType

@Dao
interface CarTypeDao {
    @Query("SELECT * FROM cartype")
    suspend fun getAll(): List<CarType>

    @Insert
    suspend fun insertAll(carList : List<CarType>)

    @Delete
    suspend fun delete(carType: CarType)
}