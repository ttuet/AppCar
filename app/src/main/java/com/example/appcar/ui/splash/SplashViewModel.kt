package com.example.appcar.ui.splash

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repository : SplashRepository
}