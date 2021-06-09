package com.example.mykotlinapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.mykotlinapp.activity.ServerActivity
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.InetAddress
import java.net.Socket


class ClientActivity : Activity() {
    private var serverIp: EditText? = null
    private var connectPhones: Button? = null
    private var serverIpAddress = "192.168.225.29" // 10.0.2.15 // machin ip 192.168.0.20 // default ip:- 10.0.2.2
    private val connected = false
    private val handler: Handler = Handler()

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.client)
        serverIp = findViewById<View>(R.id.server_ip) as EditText
        connectPhones = findViewById<View>(R.id.connect_phones) as Button

    
        connectPhones!!.setOnClickListener(View.OnClickListener {
            if (!connected) {
                if (serverIpAddress != "") {
                    val cThread: Thread = Thread(ClientThread())
                    cThread.start()

                    startActivity(Intent(this, ServerActivity::class.java))
                }
            }
        })
    }
}

class ClientThread : Runnable {
    private val serverIpAddress = "192.168.225.29" //10.0.2.15
    private var connected = false
    override fun run() {
        try {
            val serverAddr: InetAddress = InetAddress.getByName(serverIpAddress)
            Log.d("ClientActivity", "C: Connecting...")
            val socket = Socket(serverAddr, ServerActivity.SERVERPORT)
            connected = true
            while (connected) {
                try {
                    Log.d("ClientActivity", "C: Sending command.")
                    val out = PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())), true)
                    out.println("Hey Server!")

                    Log.d("ClientActivity", "C: Sent.")
                } catch (e: Exception) {
                    // TODO: handle exception
                }
                socket.close()
                Log.d("ClientActivity", "C: Closed.")
            }
        } catch (e: Exception) {
            Log.e("ClientActivity", "C: Error", e)
            connected = false
        }
    }
}