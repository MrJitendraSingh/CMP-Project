package com.example.shopeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopeapp.ui.auth.login.LoginScreen
import com.example.shopeapp.ui.auth.register.RegisterScreen
import com.example.shopeapp.ui.main.home.HomeScreen


@Composable
fun NavigationGraph(navController: NavHostController = rememberNavController(),
                    modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = ScreenRoute.RegisterScreen.route, modifier = modifier){
        composable(ScreenRoute.LoginScreen.route){
            LoginScreen{
                navController.navigate(ScreenRoute.HomeScreen.route)
            }
        }
        composable(ScreenRoute.RegisterScreen.route){
            RegisterScreen{
                navController.navigate(ScreenRoute.LoginScreen.route)
            }
        }
        composable(ScreenRoute.HomeScreen.route){
            HomeScreen()
        }
    }

}