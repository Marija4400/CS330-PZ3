package com.example.cs330_pz3.navigation

sealed class NavigationRoutes(val route: String) {
    object Home : NavigationRoutes(route = "home")
    object CheckedSastojak : NavigationRoutes(route = "checked")
    object ReceptDetailScreen: NavigationRoutes(route = "detail/{elementId}"){
        fun createRoute(elementId: String) = "detail/$elementId"
    }
}