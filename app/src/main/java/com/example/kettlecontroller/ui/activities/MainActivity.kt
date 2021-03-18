package com.example.kettlecontroller.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kettlecontroller.data.database.Kettle
import com.example.kettlecontroller.ui.theme.KettleControllerTheme
import com.example.kettlecontroller.ui.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private var kettleList = listOf<Kettle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KettleControllerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(kettleList)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.scanKettles()
        lifecycleScope.launchWhenStarted {
            viewModel.kettleFlow.collect {
                kettleList = it
                Log.e("Update", kettleList.toString())
            }
        }
    }
}

@Composable
fun Greeting(list: List<Kettle>) {
    Text(text = "$list")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KettleControllerTheme {
        Greeting(listOf(Kettle("0:0", "GS")))
    }
}

//TODO make state
//TODO make ui