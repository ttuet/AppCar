package com.example.appcar.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appcar.data.model.NoticeBoard

@Dao
interface NoticeBoardDao {
    @Query("Select * from noticeboard  where type_notice IN (:type)")
    fun getNoticeBoardDao(type : Int) : List<NoticeBoard>

    @Insert
    fun insertAll(listNotice : List<NoticeBoard>)
}