package com.example.restcountries.ui.screens

import LoginScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.restcountries.ui.screens.bookmarks.BookMarksScreen
import com.example.restcountries.ui.screens.countryDetail.CountryDetailScreen
import com.example.restcountries.ui.screens.countryList.CountryListScreen
import com.example.restcountries.ui.screens.splash.SplashScreen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationStack(
    onGoogleLoginClick: () -> Unit,
    navController: NavHostController,
    onLogOutClick: () -> Unit // <- ESTE debe existir
) {
    val context = LocalContext.current

    // ✅ Función centralizada de logout
    fun logout(context: Context) {
        // Cerrar sesión Firebase
        FirebaseAuth.getInstance().signOut()

        // Cerrar sesión Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        val googleSignInClient = GoogleSignIn.getClient(context, gso)

        googleSignInClient.signOut().addOnCompleteListener {
            // Redirigir a Login y limpiar back stack
            navController.navigate(Screens.Login.route) {
                popUpTo(0)
            }
        }
    }

    // 👇 Navegación
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screens.Login.route) {
            LoginScreen(
                onGoogleLoginClick = onGoogleLoginClick,
                navController = navController
            )
        }

        composable(Screens.CountryList.route) {
            CountryListScreen(
                navController = navController,
                onLogOutClick = { logout(context) }
            )
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
                onLogoutClick = { logout(context) }
            )
        }

        composable(Screens.BookMarks.route) {
            BookMarksScreen(
                navController = navController,
                onLogOutClick = { logout(context) }
            )
        }
    }
}
