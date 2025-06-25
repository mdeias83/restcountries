package com.example.restcountries.ui.screens

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restcountries.ui.screens.bookmarks.BookMarksScreen
import com.example.restcountries.ui.screens.countryDetail.CountryDetailScreen
import com.example.restcountries.ui.screens.countryList.CountryListScreen
//import com.example.restcountries.ui.screens.login.LoginScreen
import com.example.restcountries.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(
    onGoogleLoginClick: () -> Unit,
    navController: NavHostController,
    onLogOutClick: () -> Unit
)
{
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){
        composable (route = Screens.Splash.route){
            SplashScreen(navController = navController)
        }

        composable (route = Screens.Login.route){
            LoginScreen(
                onGoogleLoginClick,
                navController = navController

            )
        }

        composable (route = Screens.CountryList.route){
            CountryListScreen(navController = navController, onLogOutClick = onLogOutClick)
        }

        composable(
            route = Screens.CountryDetail.route,
            arguments = listOf(
                navArgument("cca3") { type = NavType.StringType },
                navArgument("isBookmarked") { type = NavType.BoolType }
            )
        ) { backStackEntry ->
            val cca3 = backStackEntry.arguments?.getString("cca3") ?: ""
            val isBookmarked = backStackEntry.arguments?.getBoolean("isBookmarked") ?: false

            CountryDetailScreen(
                cca3 = cca3,
                initialBookmarked = isBookmarked,
                navController = navController,
                onLogoutClick = onLogOutClick
            )
        }
        composable(Screens.BookMarks.route) {
            BookMarksScreen(
                navController = navController,
                onLogOutClick = onLogOutClick
            )
        }

    }
}