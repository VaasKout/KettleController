package com.example.kettlecontroller.data.repository

import android.app.Application
import com.example.kettlecontroller.data.bluetooth.BluetoothService
import com.example.kettlecontroller.data.database.Kettle
import com.example.kettlecontroller.data.database.KettleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class KettleRepository(application: Application) {

    private val kettleDao = KettleDatabase.getDatabase(application).kettleDao()
    private val bluetoothService = BluetoothService()

    val allKettles: Flow<List<Kettle>> = kettleDao.getAllKettles()

    suspend fun insertKettle(kettle: Kettle) {
        withContext(Dispatchers.IO) {
            kettleDao.insertKettle(kettle)
        }
    }

    suspend fun updateKettle(kettle: Kettle) {
        withContext(Dispatchers.IO) {
            kettleDao.updateKettle(kettle)
        }
    }

    suspend fun deleteKettle(kettle: Kettle) {
        withContext(Dispatchers.IO) {
            kettleDao.deleteKettle(kettle)
        }
    }

    suspend fun clearKettleDatabase() {
        withContext(Dispatchers.IO) {
            kettleDao.clearDatabase()
        }
    }

    suspend fun scanBluetoothDevices() {
        withContext(Dispatchers.IO) {
            val deviceList = bluetoothService.scan()
            kettleDao.insertKettleList(deviceList)
        }
    }
}