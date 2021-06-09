package com.example.mykotlinapp.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineActivity : AppCompatActivity() {

    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        textView = findViewById(R.id.text)
        println(" Main work started: ${Thread.currentThread().name}")

        GlobalScope.launch {//NON-BLOCKING
            println(" Fake work started : ${Thread.currentThread().name}")
            delay(2000)//it won't block background thread it suspends this coroutine(c1 free now next line of code can run on diff thread)
            //Thread.sleep(1000)//it blocks background thread that should not happen right?
            textView?.text="Hey Mister"
            println("Fake work stopped :${Thread.currentThread().name}")

        }
        runBlocking {
            textView?.text="Hello Madame"
            println("you are in runblocking")

            delay(1000)
        } // creates coroutine that blocks main thread
        // BLOCKS MAIN THREAD    delay(2000) } // creates coroutine that blocks main thread

        //  Thread.sleep     /blocks main thread and wait for coroutine
        println("you are in main thread")

    }
   suspend fun mySuspendingFunc(){
         delay(2000)
     }
}