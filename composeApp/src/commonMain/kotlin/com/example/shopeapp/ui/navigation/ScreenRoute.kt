package com.example.shopeapp.ui.navigation

sealed class ScreenRoute(val route: String) {
    object LoginScreen : ScreenRoute("LoginScreen")
    object RegisterScreen : ScreenRoute("RegisterScreen")
    object HomeScreen : ScreenRoute("HomeScreen")
}