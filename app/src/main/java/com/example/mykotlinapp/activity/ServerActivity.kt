package com.example.mykotlinapp.activity

import android.app.Activity
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.Handler
import android.text.format.Formatter
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.mykotlinapp.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.NetworkInterface
import java.net.ServerSocket
import java.net.SocketException


class ServerActivity : Activity() {
    private var serverStatus: TextView? = null
    private var message:TextView?=null
    private val handler = Handler()
    private var serverSocket: ServerSocket? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.server)
        serverStatus = findViewById<View>(R.id.server_status) as TextView
        message = findViewById<View>(R.id.message) as TextView?
        SERVERIP = GetDeviceipWiFiData()
        Log.d("server ip", localIpAddress!!)
        Log.d("server ip", GetDeviceipWiFiData()!!)
        val fst: Thread = Thread(ServerThread())
        fst.start()
    }

    inner class ServerThread : Runnable {
        override fun run() {
            try {
                if (SERVERIP != null) {
                    handler.post { serverStatus!!.text = "Listening on IP: " + SERVERIP }
                    serverSocket = ServerSocket(SERVERPORT)
                    while (true) {
                        // LISTEN FOR INCOMING CLIENTS
                        val client = serverSocket!!.accept()

                        handler.post { serverStatus!!.text = "Connected." }
                        try {
                            val `in` = BufferedReader(InputStreamReader(client.getInputStream()))
                            var line: String? = null
                            while (`in`.readLine().also { line = it } != null) {
                                Log.d("ServerActivity", line!!)
                                handler.post {
                                 message?.text=line!!
                                }
                            }
                            break
                        } catch (e: Exception) {
                            handler.post { serverStatus!!.text = "Oops. Connection interrupted. Please reconnect your phones." }
                            e.printStackTrace()
                        }
                    }
                } else {
                    handler.post { serverStatus!!.text = "Couldn't detect internet connection." }
                }
            } catch (e: Exception) {
                handler.post { serverStatus!!.text = "Error" }
                e.printStackTrace()
            }
        }
    }

    // GETS THE IP ADDRESS OF YOUR PHONE'S NETWORK
    private val localIpAddress: String?
        private get() {
            try {
                val en = NetworkInterface.getNetworkInterfaces()
                while (en.hasMoreElements()) {
                    val intf = en.nextElement()
                    val enumIpAddr = intf.inetAddresses
                    while (enumIpAddr.hasMoreElements()) {
                        val inetAddress = enumIpAddr.nextElement()
                        if (!inetAddress.isLoopbackAddress) {
                            return inetAddress.hostAddress.toString()
                        }
                    }
                }
            } catch (ex: SocketException) {
                Log.e("ServerActivity", ex.toString())
            }
            return null
        }

    override fun onStop() {
        super.onStop()
        try {
            // MAKE SURE YOU CLOSE THE SOCKET UPON EXITING
            serverSocket!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        // DEFAULT IP
        var SERVERIP: String? = "192.168.0.20" // 10.0.2.15

        // DESIGNATE A PORT
        const val SERVERPORT = 4000 // 8080
    }

   private fun GetDeviceipWiFiData(): String? {
        val wm = getApplicationContext().getSystemService(WIFI_SERVICE) as WifiManager
        return Formatter.formatIpAddress(wm.connectionInfo.ipAddress)
    }
}