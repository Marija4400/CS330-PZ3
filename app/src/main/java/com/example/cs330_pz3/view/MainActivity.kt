package com.example.cs330_pz3.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.cs330_pz3.navigation.NavSetup
import com.example.cs330_pz3.ui.theme.CS330PZ3Theme

class MainActivity : ComponentActivity() {


    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS330PZ3Theme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                NavSetup(navController = navController)

            }
        }
    }
}

