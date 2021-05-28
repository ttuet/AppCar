package com.example.appcar.ui.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.appcar.R

class ListRoadFragment : Fragment() {

    companion object {
        fun newInstance() = ListRoadFragment()
    }

    private lateinit var viewModel: ListRoadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_road_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListRoadViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()
        Log.d("ListRoad", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FeedBack", "OnResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.d("FeedBack", "OnPause: ")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("FeedBack", "onSaveInstanceState: ")

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("FeedBack", "onViewStateRestored: ")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FeedBack", "onDestroyView: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FeedBack", "onDestroy: ")

    }
}