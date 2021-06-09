package com.example.mykotlinapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.example.mykotlinapp.databinding.ActivityShareViewModelBinding
import com.example.mykotlinapp.viewmodel.SharedViewMOdel

class ShareViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareViewModelBinding
    private lateinit var sharedViewMOdel: SharedViewMOdel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShareViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}