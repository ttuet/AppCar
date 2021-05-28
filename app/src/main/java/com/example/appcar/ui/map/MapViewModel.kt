package com.example.appcar.ui.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcar.data.model.CarType
import com.example.appcar.data.model.Road
import java.util.ArrayList
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var repository: MapRepository

    private val viewModelCoroutineScope = CoroutineScope(Dispatchers.IO)

    private val _allData = MutableLiveData<List<Road>>()
    val allData: MutableLiveData<List<Road>> get() = _allData

    private val _listCarType = MutableLiveData<List<CarType>>()
    val listCarType: MutableLiveData<List<CarType>> get() = _listCarType

    private var listChoose = ArrayList<Int>()
    fun insertAll() {
        val lisRoad = ArrayList<Road>()
        lisRoad.add(
            Road(
                1,
                "Nguyến Thái Học",
                21.025126, 105.821595,
                21.025126, 105.818816,
                " Cấm 2 chieu vào các giờ",
                true
            )
        )
        lisRoad.add(
            Road(
                2,
                "Nguyến Luong Banwgf",
                21.025126, 105.818816,
                21.025126, 105.818816,
                " Cấm 2 chiêuv vào các giờ",
                false
            )
        )
        lisRoad.add(
            Road(
                3,
                "Nguyến Hello Học",
                21.023371, 105.819691,
                21.025126, 105.818816,
                " Cấm 2 chiêuv vào các giờ",
                false
            )
        )
        lisRoad.add(
            Road(
                4,
                "Nguyến Thái Học",
                21.022628, 105.8160545,
                21.025126, 105.818816,
                " Cấm 2 chiêuv vào các giờ",
                false
            )
        )
        lisRoad.add(
            Road(
                5,
                "Nguyến Thái Học",
                21.021689, 105.815789,
                21.025126, 105.818816,
                " Cấm 2 chiêuv vào các giờ",
                true
            )
        )
        viewModelCoroutineScope.launch {
            repository.insertAll(lisRoad)
        }
    }

    fun insertCarType() {
        val listCar = ArrayList<CarType>()
        listCar.add(
            CarType(1, "Xe con"),
        )
        listCar.add(
            CarType(2, "Xe taxi"),
        )
        listCar.add(
            CarType(3, "Xe tải"),
        )
        viewModelCoroutineScope.launch {
            repository.insertCarType(listCar)
        }
    }

    fun getAllCarType() {
        viewModelCoroutineScope.launch {
            try {
                _listCarType.postValue(repository.getAllTypeCar())
            } catch (e: Exception) {

            }
        }
    }

    fun changeChoose(id: Int){
        if (listChoose.contains(id)){
                listChoose.remove(id)
        }
        else{
            listChoose.add(id)
        }

    }

    fun getAllRoad() {
        viewModelCoroutineScope.launch {
            try {

                val listIdCar = async { repository.getIdList(listChoose) }
                _allData.postValue(repository.findListCar(listIdCar.await()))
            } catch (e: Exception) {

            }
        }
    }

    // love road, change favorite
    fun loveRoad(road: Road) {
        road.isFavorite = !road.isFavorite
        viewModelCoroutineScope.launch {
            try {
                repository.updateRoad(road)
            } catch (e: Exception) {

            }
        }
    }
}