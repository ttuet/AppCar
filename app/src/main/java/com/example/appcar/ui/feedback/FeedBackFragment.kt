package com.example.appcar.ui.feedback

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.appcar.R

class FeedBackFragment : Fragment() {

    companion object {
        fun newInstance() = FeedBackFragment()
    }

    private lateinit var viewModel: FeedBackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FeedBackViewModel::class.java)
        return inflater.inflate(R.layout.feed_back_fragment, container, false)
    }
}