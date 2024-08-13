package com.sergio.bootcampfinalproject.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()
}

object TravelEarnerAppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}