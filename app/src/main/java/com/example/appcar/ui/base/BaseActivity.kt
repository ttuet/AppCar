package com.example.appcar.ui.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    companion object{
        const val DURATION_TIME_CLICKABLE = 500
    }
    private var lastTimeClick: Long = 0
    val isDoubleClick: Boolean
        get() {
            val timeNow = System.currentTimeMillis()
            if (timeNow - lastTimeClick >= DURATION_TIME_CLICKABLE) {
                // click able
                lastTimeClick = timeNow
                return false
            }
            return true
        }

    fun showLoading() {
        LoadingDialog.getInstance(this)?.show()
    }

    fun hiddenLoading() {
        LoadingDialog.getInstance(this)?.hidden()
    }
}