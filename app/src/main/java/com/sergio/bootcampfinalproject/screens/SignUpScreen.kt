package com.sergio.bootcampfinalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.sergio.bootcampfinalproject.RegistrationViewModel
import com.sergio.bootcampfinalproject.components.ButtonComponent
import com.sergio.bootcampfinalproject.components.CheckBoxComponent
import com.sergio.bootcampfinalproject.components.ClickableTextComponent
import com.sergio.bootcampfinalproject.components.DividerComponent
import com.sergio.bootcampfinalproject.components.HeadingTextComponent
import com.sergio.bootcampfinalproject.components.InputPasswordField
import com.sergio.bootcampfinalproject.components.InputTextField
import com.sergio.bootcampfinalproject.components.NormalTextComponent
import com.sergio.bootcampfinalproject.navigation.Screen
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter


@Composable
fun SignUpScreen(viewModel: RegistrationViewModel){
    var firstName by remember {mutableStateOf("")}
    var lastName by remember {mutableStateOf("")}
    var countryOfResidence by remember {mutableStateOf("")}
    var email by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var message by remember {mutableStateOf("")}
    var checkedState by remember { mutableStateOf(false) }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            NormalTextComponent("Hey there, ")
            HeadingTextComponent("Create an Account")
            Spacer(modifier = Modifier.height(20.dp))
            InputTextField(
                labelValue="First Name",
                icon=Icons.Outlined.AccountCircle,
                value = firstName,
                onValueChange = { newValue -> firstName = newValue}
            )
            InputTextField(
                labelValue="Last Name",
                icon=Icons.Outlined.AccountCircle,
                value = lastName,
                onValueChange = { newValue -> lastName = newValue}
            )
            InputTextField(
                labelValue="Country of Residence",
                icon=Icons.Outlined.Home,
                value = countryOfResidence,
                onValueChange = { newValue -> countryOfResidence = newValue}
            )
            InputTextField(
                labelValue="Email",
                icon=Icons.Outlined.Email,
                value = email,
                onValueChange = { newValue -> email = newValue}
            )
            InputPasswordField(
                labelValue="Password",
                icon=Icons.Default.Lock,
                value = password,
                onValueChange = { newValue -> password = newValue }
            )
            CheckBoxComponent(
                checkedState = checkedState,
                onCheckedChange = { isChecked -> checkedState = isChecked }
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = message,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            ButtonComponent(
                value = "Register",
                onButtonClick = {
                    if(!checkedState){
                        message = "Please accept the Privacy Policy and Terms of Use before proceeding."
                    } else if(isPasswordStrong(password)){
                        viewModel.register(firstName, lastName, countryOfResidence, email, password) {result ->
                            message = result
                        }
                    TravelEarnerAppRouter.navigateTo(Screen.AvailableAdsScreen)
                    }else{
                    message = "Weak password."
                    }
                }
            )
            DividerComponent()
            ClickableTextComponent(
                initialText = "Already have an account? ",
                clickableText = "Login",
                onTextSelected = {
                    TravelEarnerAppRouter.navigateTo(Screen.LoginScreen)
                }
            )
        }

    }
}

fun isPasswordStrong(password: String): Boolean {
    val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$")
    return passwordPattern.matches(password)
}