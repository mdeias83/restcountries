package com.example.restcountries.ui.screens

sealed class Screens (val route: String){
    object Splash: Screens("splash_screen")
    object CountryList: Screens("country_list_screen")

    object CountryDetail : Screens("country_detail_screen/{cca3}/{isBookmarked}") {
        fun createRoute(cca3: String, isBookmarked: Boolean): String {
            return "country_detail_screen/$cca3/$isBookmarked"
        }
    }
    object Login: Screens("login_screen")
    object BookMarks: Screens("bookmarks_screen")
}