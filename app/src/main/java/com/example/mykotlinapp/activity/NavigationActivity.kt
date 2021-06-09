package com.example.mykotlinapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinapp.R

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

       println(listOf(1, 2, 3).fold(0) { sum, element -> sum + element })
       println(listOf(1, 2, 3).reduce { sum, element -> sum + element })

    }
}