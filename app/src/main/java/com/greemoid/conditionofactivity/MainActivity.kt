package com.greemoid.conditionofactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greemoid.conditionofactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}