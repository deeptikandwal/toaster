package com.example.mykotlinapp

sealed class ConstructorRunner(age: Int) {

    var age: Int = age
    var name: String = ""

    init {
        this.age=age
    }
    constructor(age: Int, secname: String) : this(age) {
        this.name = secname
    }
}