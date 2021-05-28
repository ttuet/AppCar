package com.example.appcar.ui.map

import android.os.Handler
import android.os.Looper
import com.example.appcar.data.CarTypeDao
import com.example.appcar.data.RelationDao
import com.example.appcar.data.RoadDao
import com.example.appcar.data.model.CarType
import com.example.appcar.data.model.Road
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val roadDao: RoadDao,
    private val carTypeDao: CarTypeDao,
    private val relationDao: RelationDao

) {

    //    fun getRoadByType() : List<Road> {
//        executorService.execute(
//            roadDao.findByCarType()
//        )
//    }
    suspend fun insertCarType(carList: List<CarType>) = carTypeDao.insertAll(carList)

    suspend fun getAllTypeCar() = carTypeDao.getAll()

    suspend fun updateRoad(road: Road) = roadDao.updateRoad(road)

    suspend fun insertAll(roadList: List<Road>) = roadDao.insertAll(roadList)

    suspend fun getAll() = roadDao.getAll()

    suspend fun findListCar(roadList: List<Int>) = roadDao.findCar(roadList)

    suspend fun getIdList(carList: List<Int>) = relationDao.getRoadByType(carList)
}
