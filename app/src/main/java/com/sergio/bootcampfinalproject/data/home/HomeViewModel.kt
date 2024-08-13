package com.sergio.bootcampfinalproject.data.home

import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergio.bootcampfinalproject.navigation.Screen

class HomeViewModel : ViewModel() {

    private val TAG = HomeViewModel::class.simpleName

    /*val navigationItemsList = listOf<NavigationItem>(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            description = "Home Screen",
            itemId = "homeScreen"
        ),
        NavigationItem(
            title = "Settings",
            icon = Icons.Default.Settings,
            description = "Settings Screen",
            itemId = "settingsScreen"
        ),
        NavigationItem(
            title = "Favorite",
            icon = Icons.Default.Favorite,
            description = "Favorite Screen",
            itemId = "favoriteScreen"
        )
    )*/

    var isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun logout() {
                Log.d(TAG, "Sign out success")
        TravelEarnerAppRouter.navigateTo(Screen.SignUpScreen)
        }

    fun checkForActiveSession() {
            Log.d(TAG, "Valid session")
            isUserLoggedIn.value = true;
    }

    var emailId: MutableLiveData<String> = MutableLiveData()

    fun getUserData() {
                emailId.value = "email@test.com"
    }

}