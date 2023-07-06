package com.example.zaratest.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zaratest.R
import com.example.zaratest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
    }
}