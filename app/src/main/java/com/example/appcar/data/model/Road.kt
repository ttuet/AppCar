package com.example.appcar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

@Entity
data class Road(

    @PrimaryKey val id: Int,

    var name: String,

    var start_lat: Double,

    var start_lng: Double,

    var end_lat: Double,

    var end_lng: Double,

    var description: String,

    @SerializedName("is_favourite")
    @ColumnInfo(name = "is_favourite") var isFavorite: Boolean
)