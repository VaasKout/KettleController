package com.example.kettlecontroller.data

import com.example.kettlecontroller.data.database.Kettle

interface BluetoothHandler {
    fun scan(): List<Kettle>
}