package com.example.appcar.ui.splash

import com.example.appcar.data.CarTypeDao
import com.example.appcar.data.RelationDao
import com.example.appcar.data.RoadDao
import javax.inject.Inject

class SplashRepository @Inject constructor(
    private val roadDao: RoadDao,
    private val carTypeDao: CarTypeDao,
    private val relationDao: RelationDao
) {
}