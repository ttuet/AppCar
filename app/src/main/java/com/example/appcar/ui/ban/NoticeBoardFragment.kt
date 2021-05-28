package com.example.appcar.ui.ban

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appcar.R

class NoticeBoardFragment : Fragment() {

    companion object {
        fun newInstance() = NoticeBoardFragment()
    }

    private lateinit var viewModel: NoticeBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notice_board_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoticeBoardViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        Log.d("NoticeBoard", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("NoticeBoard", "OnResume: ")

    }

    override fun onPause() {
        super.onPause()
        Log.d("NoticeBoard", "OnPause: ")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("NoticeBoard", "onSaveInstanceState: ")

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("NoticeBoard", "onViewStateRestored: ")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("NoticeBoard", "onDestroyView: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("NoticeBoard", "onDestroy: ")

    }
}