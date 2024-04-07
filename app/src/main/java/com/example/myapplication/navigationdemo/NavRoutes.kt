package com.example.myapplication.navigationdemo

sealed class NavRoutes(val route: String) {
    data object Home: NavRoutes("home")
    data object Welcome: NavRoutes("welcome")
    data object Profile: NavRoutes("profile")
}