package com.sergio.bootcampfinalproject.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()
    data object AvailableAdsScreen : Screen()
    data object CreateNewAd : Screen()
}

object TravelEarnerAppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.LoginScreen)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}