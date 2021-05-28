package com.example.appcar.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appcar.data.model.CarType
import com.example.appcar.data.model.NoticeBoard
import com.example.appcar.data.model.RelationRoadCar
import com.example.appcar.data.model.Road

@Database(entities = [Road::class, CarType::class, RelationRoadCar::class, NoticeBoard::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roadDao() : RoadDao
    abstract fun carTypeDao() : CarTypeDao
    abstract fun relationDao() : RelationDao
    abstract fun noticeBoardDao() : NoticeBoardDao
}