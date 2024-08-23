package com.sergio.bootcampfinalproject.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sergio.bootcampfinalproject.RegistrationViewModel
import com.sergio.bootcampfinalproject.navigation.Screen
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter
import com.sergio.bootcampfinalproject.screens.SignUpScreen
import com.sergio.bootcampfinalproject.screens.LoginScreen
import com.sergio.bootcampfinalproject.screens.CreateNewAd

@Composable
fun TravelEarnerApp(viewModel: RegistrationViewModel) {
    Surface (
        modifier = Modifier
        .fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = TravelEarnerAppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen(viewModel)
                }
                is Screen.LoginScreen -> {
                    LoginScreen(viewModel)
                }
                is Screen.AvailableAdsScreen -> {
                    Avai
                }
                is Screen.CreateNewAd -> {
                    CreateNewAd(viewModel)
                }
            }

        }

    }
}