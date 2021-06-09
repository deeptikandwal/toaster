package com.example.mykotlinapp

sealed class SealedRunner{

data class Manager(val projects: Int, val name: String) : SealedRunner()
object Single:SealedRunner()
class RegularEmployee(val name: String,val salary:Int):SealedRunner()
}