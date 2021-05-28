package com.example.appcar.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Relation
import com.example.appcar.data.model.RelationRoadCar

@Dao
interface RelationDao {

    @Query("Select road_id from relationroadcar where car_type_id IN (:type) order by car_type_id")
    suspend fun getRoadByType(type : List<Int>) : List<Int>

    @Insert
    suspend fun insert(relation: RelationRoadCar)
}