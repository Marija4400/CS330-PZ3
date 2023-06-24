package com.example.cs330_pz3.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cs330_pz3.AppViewModel
import com.example.cs330_pz3.view.CheckedSastojak
import com.example.cs330_pz3.view.HomeScreen
import com.example.cs330_pz3.view.ReceptDetailScreen

@Composable
fun NavSetup(navController: NavHostController) {
    val vm: AppViewModel = viewModel()
    var paddingValues = PaddingValues()
    vm.navController = navController

    NavHost(navController = navController, startDestination = NavigationRoutes.Home.route) {
        composable(route = NavigationRoutes.Home.route) {
            HomeScreen(vm, paddingValues)
        }
        composable(route = NavigationRoutes.ReceptDetailScreen.route) { navBackStackEntry ->
            val elementId = navBackStackEntry.arguments?.getString("elementId")
            if (elementId != null) {
                ReceptDetailScreen(vm, elementId, paddingValues)
            }else{
                Toast.makeText(navController.context, "Error, elementId is required!", Toast.LENGTH_SHORT).show()
            }
        }
        composable(route = NavigationRoutes.CheckedSastojak.route) {
            CheckedSastojak(vm, paddingValues)
        }
    }
}