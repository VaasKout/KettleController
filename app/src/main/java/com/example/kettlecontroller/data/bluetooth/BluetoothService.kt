package com.example.kettlecontroller.data.bluetooth

import com.example.kettlecontroller.data.interfaces.BluetoothHandler
import com.example.kettlecontroller.data.database.Kettle

class BluetoothService : BluetoothHandler {
    override fun scan(): List<Kettle> {
        return listOf(Kettle("0:0", "GS"))
    }
}