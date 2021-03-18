package com.example.kettlecontroller.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kettlecontroller.data.database.KettleDatabase
import com.example.kettlecontroller.data.repository.KettleRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = KettleRepository(application)
    val kettleFlow = repository.allKettles

    fun scanKettles() {
        viewModelScope.launch {
            repository.scanBluetoothDevices()
        }
    }
}