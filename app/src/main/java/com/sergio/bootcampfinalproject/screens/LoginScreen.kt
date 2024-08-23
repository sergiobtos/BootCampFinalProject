package com.sergio.bootcampfinalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sergio.bootcampfinalproject.RegistrationViewModel
import com.sergio.bootcampfinalproject.components.ButtonComponent
import com.sergio.bootcampfinalproject.components.ClickableTextComponent
import com.sergio.bootcampfinalproject.components.DividerComponent
import com.sergio.bootcampfinalproject.components.HeadingTextComponent
import com.sergio.bootcampfinalproject.components.InputPasswordField
import com.sergio.bootcampfinalproject.components.InputTextField
import com.sergio.bootcampfinalproject.components.NormalTextComponent
import com.sergio.bootcampfinalproject.components.UnderLinedTextComponent
import com.sergio.bootcampfinalproject.navigation.Screen
import com.sergio.bootcampfinalproject.navigation.SystemBackButtonHandler
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter


@Composable
fun LoginScreen(viewModel: RegistrationViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember {mutableStateOf("")}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            NormalTextComponent("Login")
            HeadingTextComponent(value = "Welcome Back")
            Spacer(modifier = Modifier.height(20.dp))
            InputTextField(
                labelValue="Email",
                icon= Icons.Outlined.Email,
                value = email,
                onValueChange = { newValue -> email = newValue}
            )
            InputPasswordField(
                labelValue="Password",
                icon= Icons.Default.Lock,
                value = password,
                onValueChange = {newValue -> password = newValue}
            )
            Spacer(modifier = Modifier.height(40.dp))
            UnderLinedTextComponent(value = "Forgot your password?")
            Spacer(modifier = Modifier.height(140.dp))
            Text(text = message)
            ButtonComponent(
                value = "Login",
                onButtonClick = {
                    viewModel.signInWithEmailAndPassword(email, password) {isSuccess, errorMessage ->
                        if(isSuccess){
                            TravelEarnerAppRouter.navigateTo(Screen.AvailableAdsScreen)
                        }else{
                            message = "Sign-in failed: $errorMessage"
                        }
                    }
                }
            )
            DividerComponent()
            ClickableTextComponent(
                initialText = "Don't have an account yet? ",
                clickableText = "Register",
                onTextSelected = {
                    TravelEarnerAppRouter.navigateTo(Screen.SignUpScreen)
                }
            )
        }
    }

    SystemBackButtonHandler{
        TravelEarnerAppRouter.navigateTo(Screen.SignUpScreen)
    }
}