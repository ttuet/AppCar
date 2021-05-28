package com.example.appcar.ui.base

import androidx.fragment.app.Fragment
import com.example.appcar.ui.base.BaseActivity

abstract class BaseFragment : Fragment() {


    protected val isDoubleClick: Boolean
        get() {
            if (activity == null) {
                return false
            }
            return if (activity is BaseActivity) {
                (activity as BaseActivity?)!!.isDoubleClick
            } else false
        }

    private fun showLoading() {
        if (activity != null && activity is BaseActivity) {
            (activity as BaseActivity?)!!.showLoading()
        }
    }

    private fun hideLoading() {
        if (activity != null && activity is BaseActivity) {
            (activity as BaseActivity?)!!.hiddenLoading()
        }
    }
}