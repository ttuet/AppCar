package com.example.appcar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RelationRoadCar (
    @PrimaryKey
    val id : Int,
    @ColumnInfo(name = "car_type_id") val carTypeId : Int,
    @ColumnInfo(name = "road_id") val roadId: Int
    )