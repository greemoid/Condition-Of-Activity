package com.greemoid.conditionofactivity

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.greemoid.conditionofactivity.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btIncrement.setOnClickListener{ incrementCounter() }
            btColor.setOnClickListener { setRandomColor() }
            btVisibility.setOnClickListener { changeVisibility() }
        }
    }

    private fun changeVisibility() = with(binding) {
        val visibility = if (tvCounter.isVisible) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
        tvCounter.visibility = visibility
    }

    private fun setRandomColor() {
        val textColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        binding.tvCounter.setTextColor(textColor)
    }

    private fun incrementCounter() {
        var counter = binding.tvCounter.text.toString().toInt()
        counter++
        binding.tvCounter.text = counter.toString()
    }
}