package com.example.mykotlinapp.viewmodel

import android.app.Application
import androidx.databinding.BindingMethod
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SharedViewMOdel(application: Application) : AndroidViewModel(application) {
    val message = MutableLiveData<String>()
    fun sendMessage(text: String) {
        message.value=text
    }


}