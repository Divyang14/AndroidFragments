package com.example.androidfragments

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("MyService","tests")
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}