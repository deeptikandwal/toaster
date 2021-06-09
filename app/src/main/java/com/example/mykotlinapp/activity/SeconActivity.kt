package com.example.mykotlinapp.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

//primary constructor
class SeconActivity(var name: String = "Deepti") : AppCompatActivity() {

    //    var n:String=name
    var n: String = ""

    //secondary constructor
    init {
        n = name
    }

    //secondary constructor and here we are performing constructor chaining
    constructor(  age: Int, name: String) : this(name) {
        this.name=name
        println("name of the user is $name  and age is $age")
    }

    var skills: String = ""
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }


}