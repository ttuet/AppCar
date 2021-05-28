package com.example.appcar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoticeBoard(
    @PrimaryKey
    val id: String,

    val name: String,

    val des: String,

    @ColumnInfo(name = "img_src")
    val imgSrc : String,

    @ColumnInfo(name = "type_notice")
    val typeNotice : Int
)
