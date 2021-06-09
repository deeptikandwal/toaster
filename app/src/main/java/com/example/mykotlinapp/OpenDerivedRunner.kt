package com.example.mykotlinapp

open class OpenDerivedRunner {
    protected open val fieldA: String = "Some value"
}
class DerivedContainer : OpenDerivedRunner() {
   override val fieldA: String = "Something else"
}
