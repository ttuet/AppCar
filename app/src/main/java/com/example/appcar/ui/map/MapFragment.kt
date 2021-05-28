package com.example.appcar.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.SnapHelper
import com.example.appcar.R
import com.example.appcar.data.model.CarType
import com.example.appcar.data.model.Road
import com.example.appcar.ui.adapter.ItemCarTypeAdapter
import com.example.appcar.ui.adapter.ItemMapRoadAdapter
import com.example.appcar.ui.base.BaseFragment
import com.example.appcar.util.MyApplication
import com.example.appcar.util.StartSnapHelper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.map_fragment.*

@AndroidEntryPoint
class MapFragment : BaseFragment(), OnMapReadyCallback {

    private var listRoadContent = ArrayList<Road>()
    private var listCarType = ArrayList<CarType>()
    private var roadAdapter: ItemMapRoadAdapter? = null
    private var carTypeAdapter: ItemCarTypeAdapter? = null

    private lateinit var googleMap: GoogleMap

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel

    override fun onStart() {
        super.onStart()
        viewModel.getAllRoad()
        viewModel.getAllCarType()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MapViewModel::class.java)
        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.mapContainer) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpViews()
    }

    private fun setUpViews() {

        roadAdapter = ItemMapRoadAdapter(ItemMapRoadAdapter.VIEW_TYPE_MAP,listRoadContent,
            {
                onClickRoadItem(it)
            },
            {

                onClickLoveRoadItem(it)
            })
        rlvListRoad.adapter = roadAdapter
        val startSnapHelper: SnapHelper = StartSnapHelper()
        startSnapHelper.attachToRecyclerView(rlvListRoad)

        carTypeAdapter = ItemCarTypeAdapter(listCarType) {
            chooseTypeListener(it)
        }
        rlvListType.adapter = carTypeAdapter


    }


    private fun chooseTypeListener(id: Int){
        viewModel.changeChoose(id)
    }

    private fun setUpObservers() {

        viewModel.allData.observe(
            viewLifecycleOwner,
            {
                listRoadContent = it as ArrayList<Road>
                roadAdapter?.updateList(listRoadContent)

            }
        )

        viewModel.listCarType.observe(
            viewLifecycleOwner,
            {
                listCarType = it as ArrayList<CarType>
                carTypeAdapter?.updateList(listCarType)
            }
        )
    }

    private fun onClickLoveRoadItem(road: Road) {
        viewModel.loveRoad(road)
        roadAdapter?.notifyItemChanged(listRoadContent.indexOf(road))
    }


    private fun onClickRoadItem(road: Road) {
        val position = LatLng(road.start_lat, road.start_lng)
        val markerOptions = MarkerOptions()
        markerOptions.position(position)
        googleMap.addMarker(markerOptions)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 10f))

    }

    override fun onMapReady(it: GoogleMap?) {
        if (it != null) {
            googleMap = it
        }
        it?.setOnMapClickListener { latLng ->
            val markerOption = MarkerOptions()
            markerOption.position(latLng)
            markerOption.title(latLng.latitude.toString() + " : " + latLng.longitude.toString())
            it.addMarker(markerOption)
            it.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10F))
        }
    }

}