package com.sergio.bootcampfinalproject.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sergio.bootcampfinalproject.data.home.HomeViewModel
import com.sergio.bootcampfinalproject.navigation.Screen
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter
import com.sergio.bootcampfinalproject.screens.SignUpScreen

@Composable
fun TravelEarnerApp(homeViewModel: HomeViewModel = viewModel()) {
    Surface (
        modifier = Modifier
        .fillMaxSize(),
        color = Color.White
    ) {
        if(homeViewModel.isUserLoggedIn.value == true){
            //should be HomeScreen
            TravelEarnerAppRouter.navigateTo(Screen.SignUpScreen)
        }

        Crossfade(targetState = TravelEarnerAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.LoginScreen -> {
                    //LoginScreen()
                }
            }

        }

    }
}