package com.example.appcar.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appcar.MainActivity
import com.example.appcar.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    lateinit var viewModel : SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        btn.setOnClickListener{
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}