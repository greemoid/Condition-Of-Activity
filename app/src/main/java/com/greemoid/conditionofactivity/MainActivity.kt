package com.greemoid.conditionofactivity

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.core.view.isVisible
import com.greemoid.conditionofactivity.databinding.ActivityMainBinding
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var state: State

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btIncrement.setOnClickListener{ incrementCounter() }
            btColor.setOnClickListener { setRandomColor() }
            btVisibility.setOnClickListener { changeVisibility() }
        }
        state = if (savedInstanceState == null) {
            State (
                contentValue = 0,
                textColorValue = getColor(R.color.black),
                textVisibility = View.VISIBLE
                    )
        } else {
            savedInstanceState.getParcelable(KEY_STATE)!!
        }
        renderState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }

    private fun changeVisibility() = with(binding) {
        state.textVisibility = if (tvCounter.isVisible) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
        renderState()
    }

    private fun setRandomColor() {
        state.textColorValue = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        renderState()
    }

    private fun incrementCounter() {
        state.contentValue++
        renderState()
    }

    private fun renderState() {
        binding.tvCounter.text = state.contentValue.toString()
        binding.tvCounter.setTextColor(state.textColorValue)
        binding.tvCounter.visibility = state.textVisibility
    }

    @Parcelize
    class State (
        var contentValue: Int,
        var textColorValue: Int,
        var textVisibility: Int
        ): Parcelable
    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
    }
}