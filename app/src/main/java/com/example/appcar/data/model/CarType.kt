package com.example.appcar.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CarType (
    @PrimaryKey
    var id : Int,

    var name : String,
)