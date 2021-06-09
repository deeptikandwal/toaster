package com.example.mykotlinapp
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MyTest {
@Test
fun myTestFunct()= runBlocking{
    Assert.assertEquals(10,5+5)
}

}