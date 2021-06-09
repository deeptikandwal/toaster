package com.example.mykotlinapp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.mykotlinapp.IMyAidlInterface

class MyService : Service() {

    companion object {
        val TAG: String = "MyService"
    }


    val stub: IMyAidlInterface.Stub = object : IMyAidlInterface.Stub() {
        override fun asBinder(): IBinder {
            TODO("Not yet implemented")
        }

        override fun add(val1: Int, val2: Int): Int {

            return val1 + val2;
        }

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {
            TODO("Not yet implemented")
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return stub;
    }
}